package wot.core.lib.http_ktx

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @Sub 网络
 * @Say 不要问为什么! 问就是懒, 不想写那么多代码!
 * @Description 网络请求扩展类
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
fun <T> CoroutineScope.requestData(
    /**
     * 事件函数
     */
    action: RequestAction<T>.() -> Unit,
): LiveData<ResultData<T>> {

    // 获取到网络请求的实现
    val request = RequestAction<T>().apply(action)

    // 返回一个 LiveData 的协程
    return liveData(this.coroutineContext) {
        // 开始请求网络, 给订闻者发送开始请求状态
        emit(ResultData.start<T>())

        // 加载数据库缓存的数据
        request.mLoadCache?.invoke()?.let {
            val cacheResult = Transformations.map<T, ResultData<T>>(it) { resultType ->
                val result = Response<T>()
                result.data = resultType
                ResultData.success(result, true)
            }
            emitSource(cacheResult)
        }

        val apiResponse = try {
            // 开始请求网络 执行 api 的 suspend 函数
            val response = request.api?.invoke()
            ApiResponse.create(response)
        } catch (e: Exception) {
            // 处理全局的异常
            ApiResponse.create(e)
        }

        // 结果处理
        when (apiResponse) {
            // 成功处理
            is ApiResponse.ApiSuccessResponse -> {
                val result = apiResponse.body?.data
                // 将 data 缓存到数据库
                request.mSaveCache?.let {
                    withContext(Dispatchers.IO) {
                        it.invoke(result)
                    }
                }
                // 发送成功数据
                emit(ResultData.success<T>(apiResponse.body))
            }
            // 业务错误处理
            is ApiResponse.ApiBusinessErrorResponse -> {
                val apiException = HttpBuilder.apiBusinessErrorAdapter?.convert(apiResponse.throwable)
                // 给请求方发送一份
                emit(ResultData.error<T>(apiException ?: apiResponse.throwable, apiResponse.body))
            }
            // 异常处理
            is ApiResponse.ApiExceptionResponse -> {
                val apiException = HttpBuilder.apiExceptionAdapter!!.convert(apiResponse.throwable)
                // 给请求方发送一份
                emit(ResultData.error<T>(apiException, null))
            }
        }
        emit(ResultData.done(null))
    }
}