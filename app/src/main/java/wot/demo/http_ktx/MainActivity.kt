package wot.demo.http_ktx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import wot.core.lib.http_ktx.RequestStatus
import wot.demo.http_ktx.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val mMainViewModel = MainViewModel()

    lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mMainViewModel.bannerLiveData.observe(this) { data ->
            when (data.requestStatus) {
                RequestStatus.START -> {
                    dataBinding.bannerView.text = "bannerView: Loading..."
                }
                RequestStatus.SUCCESS -> {
                    dataBinding.bannerView.text = "bannerView: Success ${data.response?.data?.size}"
                }
                RequestStatus.ERROR -> {
                    dataBinding.bannerView.text = "bannerView: Error ${data.error?.message}"
                }
                else -> {

                }
            }
        }

        mMainViewModel.recipesLiveData.observe(this) { data ->
            when (data.requestStatus) {
                RequestStatus.START -> {
                    dataBinding.recipesView.text = "recipesView: Loading..."
                }
                RequestStatus.SUCCESS -> {
                    dataBinding.recipesView.text = "recipesView: Success ${data.response?.data?.size}"
                }
                RequestStatus.ERROR -> {
                    dataBinding.recipesView.text = "recipesView: Error ${data.error?.message}"
                }
                else -> {

                }
            }
        }

        mMainViewModel.topicsLiveData.observe(this) { data ->
            when (data.requestStatus) {
                RequestStatus.START -> {
                    dataBinding.topicsView.text = "topicsView: Loading..."
                }
                RequestStatus.SUCCESS -> {
                    dataBinding.topicsView.text = "topicsView: Success ${data.response?.data?.size}"
                }
                RequestStatus.ERROR -> {
                    dataBinding.topicsView.text = "topicsView: Error ${data.error?.message}"
                }
                else -> {

                }
            }
        }

        mMainViewModel.getBanner()
        mMainViewModel.getRecipes()
        mMainViewModel.getTopics()
    }
}