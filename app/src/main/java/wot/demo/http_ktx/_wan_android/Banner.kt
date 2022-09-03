package wot.demo.http_ktx._wan_android

/**
 * @Sub 附属
 * @Description 作用
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
data class Banner(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)