package wot.demo.http_ktx._wan_android

import wot.core.lib.http_ktx.Response

/**
 * @Sub 附属
 * @Description 作用
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
class WanAndroidResponse<T> : Response<T>() {

    var errorCode: Int = -1

    var errorMsg: String = ""

    override var code: Int
        get() = errorCode
        set(value) {
            errorCode = value
        }

    override var msg: String
        get() = errorMsg
        set(value) {
            errorMsg = value
        }
}