package wot.core.lib.http_ktx.adapter

import wot.core.lib.http_ktx.ApiException

/**
 * @Sub 网络
 * @Say 处理特殊业务而拓展(例如: token过期)
 * @Description 业务错误适配器
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
interface IApiBusinessErrorAdapter {

    /**
     * 将异常转换为 ApiException
     */
    fun convert(apiException: ApiException?): ApiException?
}