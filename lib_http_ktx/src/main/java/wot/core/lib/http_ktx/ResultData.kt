package wot.core.lib.http_ktx

/**
 * @Sub 网络
 * @Description 数据实体的包装类(含结果、状态), 最终回调使用的是它
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
data class ResultData<T>(
    val requestStatus: RequestStatus,
    val response: Response<T>?,
    val isCache: Boolean = false,
    val error: ApiException? = null,
) {
    companion object {

        /**
         * 开始
         * @Tips 可做加载进度显示
         */
        fun <T> start(): ResultData<T> {
            return ResultData(RequestStatus.START, null)
        }

        /**
         * 成功
         * @Tips 可能会为 null, 自行判断处理
         */
        fun <T> success(data: Response<T>?, isCache: Boolean = false): ResultData<T> {
            return ResultData(RequestStatus.SUCCESS, data, isCache)
        }

        /**
         * 错误
         * @Tips 建议实现 IApiBusinessErrorAdapter 处理业务错误, 实现 IApiExceptionAdapter 处理异常
         * @param data 兼容某些接口成功和失败的 msg 都放在 data 的情况
         */
        fun <T> error(error: ApiException?, data: Response<T>?): ResultData<T> {
            return ResultData(RequestStatus.ERROR, data, false, error)
        }

        /**
         * 结束
         * @Tips 发送的是 null, 该事件主要用于订阅移除
         */
        fun <T> done(data: Response<T>?): ResultData<T> {
            return ResultData(RequestStatus.DONE, data)
        }
    }
}