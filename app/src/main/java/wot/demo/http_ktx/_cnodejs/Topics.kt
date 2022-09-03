package wot.demo.http_ktx._cnodejs

/**
 * @Sub 附属
 * @Description 作用
 * @Author Wot.Yang
 * @CreateDate 2022/8/16
 * @Organization: Wot
 */
data class Topics(
    val author: Author,
    val author_id: String,
    val create_at: String,
    val good: Boolean,
    val id: String,
    val last_reply_at: String,
    val reply_count: Int,
    val tab: String,
    val title: String,
    val top: Boolean,
    val visit_count: Int
)

data class Author(
    val avatar_url: String,
    val loginname: String
)