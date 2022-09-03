package wot.demo.http_ktx._cnodejs

import retrofit2.converter.gson.GsonConverterFactory
import wot.core.lib.http_ktx.HttpBuilder
import wot.demo.http_ktx.interceptor.loggingInterceptor

/**
 * @Sub 论坛
 * @Description 作用
 * @Author Wot.Yang
 * @CreateDate 2022/8/16
 * @Organization: Wot
 */
val cnodejsService: CnodejsApiService by lazy {
    HttpBuilder.createService(
        CnodejsApiService.API_HOME,
        okClientAction = {
            it.addInterceptor(loggingInterceptor)
        },
        retrofitAction = {
            it.addConverterFactory(GsonConverterFactory.create())
        }
    )
}