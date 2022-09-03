package wot.core.lib.http_ktx.adapter

/**
 * @Sub 附属
 * @Description 错误code
 * @Author Wot.Yang
 * @CreateDate 2022/8/30
 * @Organization: Wot
 */
object ExceptionError {

    /**
     * http错误
     */
    const val HTTP_ERROR = -10000

    /**
     * 网络错误
     */
    const val NETWORK_ERROR = -20000

    /**
     * 未经授权
     */
    const val UNAUTHORIZED = 401

    /**
     * 服务器拒绝了请求
     */
    const val FORBIDDEN = 403

    /**
     * 找不到请求
     */
    const val NOT_FOUND = 404

    /**
     * 请求超时
     */
    const val REQUEST_TIMEOUT = 408

    /**
     * 内部服务器错误
     */
    const val INTERNAL_SERVER_ERROR = 500

    /**
     * 网关错误
     */
    const val BAD_GATEWAY = 502

    /**
     * 服务不可用
     */
    const val SERVICE_UNAVAILABLE = 503
}