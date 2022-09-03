package wot.demo.http_ktx

import android.app.Application
import wot.core.lib.http_ktx.HttpBuilder
import wot.demo.http_ktx.network.ApiBusinessErrorAdapter

/**
 * @Description app
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
class HttpKtxApp :Application() {

    override fun onCreate() {
        super.onCreate()

        HttpBuilder
            .setSuccessCode(0)
            .setApiBusinessErrorAdapter(ApiBusinessErrorAdapter())
    }
}