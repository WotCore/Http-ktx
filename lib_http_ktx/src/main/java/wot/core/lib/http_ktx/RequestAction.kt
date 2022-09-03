package wot.core.lib.http_ktx

import androidx.lifecycle.LiveData

/**
 * @Sub 网络
 * @Description 传递 DSL 包装的事件函数
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
open class RequestAction<T> {

    /**
     * 传递的就是Retrofit的Service中定义的suspend 挂起函数
     */
    var api: (suspend () -> Response<T>)? = null

    /**
     * 传递的就是加载缓存数据的函数
     */
    var mLoadCache: (() -> LiveData<T>)? = null
        private set

    /**
     * 传递的是实现缓存数据的函数
     */
    var mSaveCache: ((T?) -> Unit)? = null
        private set

    /**
     * 传递 suspend 挂起函数, 也就是 Retrofit 的 service 的方法, 该方法就是具体的网络请求
     */
    fun api(block: suspend () -> Response<T>) {
        this.api = block
    }

    /**
     * 实现读取数据的缓存
     */
    fun loadCache(block: (() -> LiveData<T>)?) {
        this.mLoadCache = block
    }

    /**
     * 实现缓存数据 (IO线程)
     */
    fun saveCache(block: ((T?) -> Unit)?) {
        this.mSaveCache = block
    }
}