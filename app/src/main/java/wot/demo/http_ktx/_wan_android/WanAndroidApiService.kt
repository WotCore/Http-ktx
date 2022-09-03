package wot.demo.http_ktx._wan_android

import retrofit2.http.GET

/**
 * @Sub 附属
 * @Description 作用
 * @Author Wot.Yang
 * @CreateDate 2022/8/16
 * @Organization: Wot
 */
interface WanAndroidApiService {

    companion object {
        /**
         * 正式环境
         */
        const val API_HOME = "https://www.wanandroid.com"
    }

    @GET("/banner/json")
    suspend fun getBanner(): WanAndroidResponse<List<Banner>>
}