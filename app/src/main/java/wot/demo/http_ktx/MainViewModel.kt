package wot.demo.http_ktx

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import wot.core.lib.http_ktx.ResultData
import wot.core.lib.http_ktx.RequestStatus
import wot.core.lib.http_ktx.requestData
import wot.demo.http_ktx._cnodejs.Topics
import wot.demo.http_ktx._cnodejs.cnodejsService
import wot.demo.http_ktx._mei_shi_china.Recipes
import wot.demo.http_ktx._mei_shi_china.meiShiChinaService
import wot.demo.http_ktx._wan_android.Banner
import wot.demo.http_ktx._wan_android.wanAndroidService

/**
 * @Sub 附属
 * @Description 作用
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
class MainViewModel : ViewModel() {

    // MediatorLiveData 只能监听数据变化
    private val _bannerLiveData = MediatorLiveData<ResultData<List<Banner>>>()

    // 对方只暴露抽象的 LiveData, 防止外部随意更改数据
    val bannerLiveData: LiveData<ResultData<List<Banner>>>
        get() = _bannerLiveData

    // todo 临时放的
    lateinit var _databaseLiveData: LiveData<List<Banner>>

    fun getBanner() {
        // viewModelScope 是系统扩展提供的 VideModel 的协程作用域
        val liveData = viewModelScope.requestData<List<Banner>> {
            // 请求网络
            api { wanAndroidService.getBanner() }

            // 加载数据缓存
            //loadCache {
            //    //数据请求, 将结果返回给 LiveData 中
            //    _databaseLiveData
            //}

            // 将数据保存到数据库
            saveCache {
                // 向数据库中保存数据
                Log.e("TAG", "getBanner: ${it?.size}")
            }
        }

        // 监听数据变化
        _bannerLiveData.addSource(liveData) { data ->
            // 网络请求完毕后 及时移除 liveData 监听
            if (data.requestStatus == RequestStatus.DONE) {
                _bannerLiveData.removeSource(liveData)
            }
            // 发送数据
            _bannerLiveData.value = data
        }
    }

    // MediatorLiveData 只能监听数据变化
    private val _recipesLiveData = MediatorLiveData<ResultData<List<Recipes>>>()

    // 对方只暴露抽象的 LiveData, 防止外部随意更改数据
    val recipesLiveData: LiveData<ResultData<List<Recipes>>>
        get() = _recipesLiveData

    fun getRecipes() {
        // viewModelScope 是系统扩展提供的 VideModel 的协程作用域
        val liveData = viewModelScope.requestData<List<Recipes>> {
            // 请求网络
            api { meiShiChinaService.getRecipes() }

            // 将数据保存到数据库
            saveCache {
                // 向数据库中保存数据
                Log.e("TAG", "getRecipes: ${it?.size}")
            }
        }

        // 监听数据变化
        _recipesLiveData.addSource(liveData) { data ->
            // 网络请求完毕后 及时移除 liveData 监听
            if (data.requestStatus == RequestStatus.DONE) {
                _recipesLiveData.removeSource(liveData)
            }
            // 发送数据
            _recipesLiveData.value = data
        }
    }

    // MediatorLiveData 只能监听数据变化
    private val _topicsLiveData = MediatorLiveData<ResultData<List<Topics>>>()

    // 对方只暴露抽象的 LiveData, 防止外部随意更改数据
    val topicsLiveData: LiveData<ResultData<List<Topics>>>
        get() = _topicsLiveData

    fun getTopics() {
        // viewModelScope 是系统扩展提供的 VideModel 的协程作用域
        val liveData = viewModelScope.requestData<List<Topics>> {
            // 请求网络
            api { cnodejsService.getTopics() }

            // 将数据保存到数据库
            saveCache {
                // 向数据库中保存数据
                Log.e("TAG", "Topics: ${it?.size}")
            }
        }

        // 监听数据变化
        _topicsLiveData.addSource(liveData) { data ->
            // 网络请求完毕后 及时移除 liveData 监听
            if (data.requestStatus == RequestStatus.DONE) {
                _topicsLiveData.removeSource(liveData)
            }
            // 发送数据
            _topicsLiveData.value = data
        }
    }
}