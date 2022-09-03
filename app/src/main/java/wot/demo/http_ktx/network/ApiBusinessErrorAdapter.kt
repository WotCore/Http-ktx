package wot.demo.http_ktx.network

import wot.core.lib.http_ktx.ApiException
import wot.core.lib.http_ktx.adapter.ExceptionError
import wot.core.lib.http_ktx.adapter.IApiBusinessErrorAdapter

/**
 * @Sub 网络
 * @Say 处理特殊业务而拓展(例如: token过期)
 * @Description api 业务错误适配器
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
class ApiBusinessErrorAdapter : IApiBusinessErrorAdapter {

    /**
     * 处理业务错误
     */
    override fun convert(apiException: ApiException?): ApiException? {
        // 处理错误码
        // todo:处理token过期, 跳转登录页
        val ex = ApiException(apiException, ExceptionError.NETWORK_ERROR)
        ex.settMessage("网络错误")
        return ex
    }
}