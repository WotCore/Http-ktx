package wot.core.lib.http_ktx.adapter

import wot.core.lib.http_ktx.ApiException

/**
 * @Sub 网络
 * @Description api 异常处理适配器
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
interface IApiExceptionAdapter {

    /**
     * 将异常转换为 ApiException
     */
    fun convert(e: Throwable): ApiException
}