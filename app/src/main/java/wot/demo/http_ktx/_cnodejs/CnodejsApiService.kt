package wot.demo.http_ktx._cnodejs

import retrofit2.http.GET

/**
 * @Sub 附属
 * @Description 网络Service
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
interface CnodejsApiService {

    companion object {
        /**
         * 正式环境
         */
        const val API_HOME = "https://cnodejs.org"
    }

    @GET("/api/v1/topics")
    suspend fun getTopics(): CnodejsResponse<List<Topics>>
}