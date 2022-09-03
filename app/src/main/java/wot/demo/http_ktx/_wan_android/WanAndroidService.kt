package wot.demo.http_ktx._wan_android

import retrofit2.converter.gson.GsonConverterFactory
import wot.core.lib.http_ktx.HttpBuilder
import wot.demo.http_ktx.interceptor.loggingInterceptor

/**
 * @Sub 玩安卓
 * @Description 作用
 * @Author Wot.Yang
 * @CreateDate 2022/8/16
 * @Organization: Wot
 */
val wanAndroidService: WanAndroidApiService by lazy {
    HttpBuilder.createService(
        WanAndroidApiService.API_HOME,
        okClientAction = {
            it.addInterceptor(loggingInterceptor)
        },
        retrofitAction = {
            it.addConverterFactory(GsonConverterFactory.create())
        }
    )
}