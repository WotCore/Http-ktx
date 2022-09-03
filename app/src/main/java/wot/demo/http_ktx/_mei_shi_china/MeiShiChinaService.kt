package wot.demo.http_ktx._mei_shi_china

import retrofit2.converter.gson.GsonConverterFactory
import wot.core.lib.http_ktx.HttpBuilder
import wot.demo.http_ktx.interceptor.loggingInterceptor

/**
 * @Sub 美食天下
 * @Description 作用
 * @Author Wot.Yang
 * @CreateDate 2022/8/16
 * @Organization: Wot
 */
val meiShiChinaService: MeiShiChinaApiService by lazy {
    HttpBuilder.createService(
        MeiShiChinaApiService.API_HOME,
        okClientAction = {
            it.addInterceptor(loggingInterceptor)
        },
        retrofitAction = {
            it.addConverterFactory(GsonConverterFactory.create())
        }
    )
}