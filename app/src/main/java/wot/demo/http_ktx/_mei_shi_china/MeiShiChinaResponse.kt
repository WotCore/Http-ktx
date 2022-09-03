package wot.demo.http_ktx._mei_shi_china

import wot.core.lib.http_ktx.Response

/**
 * @Sub 附属
 * @Description 作用
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
class MeiShiChinaResponse<T> : Response<T>() {

    var error: Int = -1

    override var code: Int
        get() = error
        set(value) {
            error = value
        }
}