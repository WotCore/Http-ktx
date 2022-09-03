package wot.core.lib.http_ktx

import java.io.Serializable

/**
 * @Sub 网络
 * @Description 数据实体, 按需重写
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
open class Response<T> : Serializable {

    open var code: Int = -1

    open var msg: String = ""

    open var data: T? = null

    open fun isSuccess(successCode: Int) = code == successCode

    open fun isFailure(successCode: Int) = !isSuccess(successCode)
}