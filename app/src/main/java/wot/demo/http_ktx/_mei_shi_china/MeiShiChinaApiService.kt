package wot.demo.http_ktx._mei_shi_china

import retrofit2.http.GET

/**
 * @Sub 附属
 * @Description 网络Service
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
interface MeiShiChinaApiService {

    companion object {
        /**
         * 正式环境
         */
        const val API_HOME = "https://home.meishichina.com"
    }

    @GET("/ajax/ajax.php?ac=recipe&op=getMoreDiffStateRecipeList&classid=0&orderby=hot&page=1n")
    suspend fun getRecipes(): MeiShiChinaResponse<List<Recipes>>
}