package wot.demo.http_ktx._cnodejs

import wot.core.lib.http_ktx.Response

/**
 * @Sub 附属
 * @Description 作用
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
class CnodejsResponse<T> : Response<T>() {

    var success: Boolean = false

    override fun isSuccess(successCode: Int) = success
}