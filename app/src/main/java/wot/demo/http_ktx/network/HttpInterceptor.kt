package wot.demo.http_ktx.interceptor

import okhttp3.logging.HttpLoggingInterceptor

/**
 * @Sub 网络
 * @Description 拦截器
 * @Author Wot.Yang
 * @CreateDate 2022/8/16
 * @Organization: Wot
 */

val loggingInterceptor: HttpLoggingInterceptor by lazy {
    val loggingInterceptor = HttpLoggingInterceptor { message ->
        println("HttpBuilder: $message")
    }
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    loggingInterceptor
}