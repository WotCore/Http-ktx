package wot.core.lib.http_ktx.adapter

import retrofit2.HttpException
import wot.core.lib.http_ktx.ApiException

/**
 * @Sub 网络
 * @Description  默认 api 异常处理适配器
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
class DefaultApiExceptionAdapter : IApiExceptionAdapter {

    override fun convert(e: Throwable): ApiException {
        val ex: ApiException
        // todo 异常迭代
        return when (e) {
            is HttpException -> {
                ex = ApiException(e, ExceptionError.HTTP_ERROR)
                when (e.code()) {
                    ExceptionError.UNAUTHORIZED -> {
                        ex.code = ExceptionError.UNAUTHORIZED
                        ex.settMessage("未经授权")
                    }
                    ExceptionError.FORBIDDEN -> ex.settMessage("服务器拒绝了请求")
                    ExceptionError.NOT_FOUND -> ex.settMessage("找不到请求")
                    ExceptionError.REQUEST_TIMEOUT -> ex.settMessage("请求超时")
                    ExceptionError.INTERNAL_SERVER_ERROR -> ex.settMessage("内部服务器错误")
                    ExceptionError.BAD_GATEWAY -> ex.settMessage("网关错误")
                    ExceptionError.SERVICE_UNAVAILABLE -> ex.settMessage("服务不可用")
                    else -> {
                        ex.settMessage("网络错误")
                    }
                }
                ex
            }
            else -> {
                ex = ApiException(e, ExceptionError.NETWORK_ERROR)
                ex.settMessage("网络错误")
                ex
            }
        }
    }
}