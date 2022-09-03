package wot.core.lib.http_ktx

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import wot.core.lib.http_ktx.adapter.DefaultApiExceptionAdapter
import wot.core.lib.http_ktx.adapter.IApiBusinessErrorAdapter
import wot.core.lib.http_ktx.adapter.IApiExceptionAdapter
import java.util.concurrent.TimeUnit

/**
 * @Sub 网络
 * @Description Http 构造
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
object HttpBuilder {

    const val DEFAULT_TIMEOUT = 30L

    /**
     * 业务层的成功码, 非成功码[successCode]下的都是业务异常, 其他情况为系统异常
     */
    internal var successCode = 0

    /**
     * api [异常处理适配器]
     */
    internal var apiExceptionAdapter: IApiExceptionAdapter? = null
        get() {
            field = field ?: DefaultApiExceptionAdapter()
            return field
        }

    /**
     * api [业务错误适配器]
     */
    internal var apiBusinessErrorAdapter: IApiBusinessErrorAdapter? = null

    /**
     * 设置 [成功状态码]
     */
    fun setSuccessCode(successCode: Int): HttpBuilder {
        this.successCode = successCode
        return this;
    }

    /**
     * 设置 [全局api异常处理适配器]
     */
    fun setApiExceptionAdapter(adapter: IApiExceptionAdapter): HttpBuilder {
        this.apiExceptionAdapter = adapter
        return this
    }

    /**
     * 设置 [全局api业务错误适配器]
     */
    fun setApiBusinessErrorAdapter(adapter: IApiBusinessErrorAdapter): HttpBuilder {
        this.apiBusinessErrorAdapter = adapter
        return this
    }

    /**
     * 创建 [Service]
     */
    inline fun <reified T> createService(
        baseUrl: String,
        connectTimeout: Long = DEFAULT_TIMEOUT,
        readTimeout: Long = DEFAULT_TIMEOUT,
        writeTimeout: Long = DEFAULT_TIMEOUT,
        noinline okClientAction: ((builder: OkHttpClient.Builder) -> Unit)?,
        noinline retrofitAction: ((builder: Retrofit.Builder) -> Unit)?,
    ): T {
        // 构建 OkClient
        val httpClient = OkHttpClient.Builder().apply {
            connectTimeout(connectTimeout, TimeUnit.SECONDS)
            readTimeout(readTimeout, TimeUnit.SECONDS)
            writeTimeout(writeTimeout, TimeUnit.SECONDS)
            okClientAction?.invoke(this)
        }.build()

        // 构建 Retrofit
        val retrofit = Retrofit.Builder().apply {
            baseUrl(baseUrl)
            client(httpClient)
            retrofitAction?.invoke(this)
        }.build()

        return retrofit.create(T::class.java)
    }
}