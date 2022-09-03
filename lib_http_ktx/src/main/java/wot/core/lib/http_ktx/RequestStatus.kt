package wot.core.lib.http_ktx

/**
 * @Sub 网络
 * @Description 网络请求状态
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
enum class RequestStatus {
    /**
     * 开始
     */
    START,

    /**
     * 成功
     */
    SUCCESS,

    /**
     * 错误
     */
    ERROR,

    /**
     * 结束
     */
    DONE
}