package wot.core.lib.http_ktx

/**
 * @Sub 网络
 * @Description 包裹响应体
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
sealed class ApiResponse<T> {

    companion object {

        fun <T> create(response: Response<T>?): ApiResponse<T> {
            return when {
                // 先根据 code 判断是否正常
                response == null || response.isFailure(HttpBuilder.successCode) -> {
                    val apiException = response?.code?.let { ApiException(it, response.msg) }
                    ApiBusinessErrorResponse(apiException, response)
                }
                else -> {
                    ApiSuccessResponse(response)
                }
            }
        }

        fun <T> create(error: Throwable): ApiExceptionResponse<T> {
            return ApiExceptionResponse(error)
        }
    }

    /**
     * 成功响应体
     */
    class ApiSuccessResponse<T>(val body: Response<T>?) : ApiResponse<T>()

    /**
     * 业务错误响应体
     */
    class ApiBusinessErrorResponse<T>(val throwable: ApiException?, val body: Response<T>?) : ApiResponse<T>()

    /**
     * 异常响应体
     */
    class ApiExceptionResponse<T>(val throwable: Throwable) : ApiResponse<T>()
}