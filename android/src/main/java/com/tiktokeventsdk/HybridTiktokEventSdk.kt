package com.tiktokeventsdk

import com.margelo.nitro.core.Promise
import com.margelo.nitro.tiktokeventsdk.HybridTiktokEventSdkSpec
import com.tiktok.TikTokBusinessSdk.*;
import com.tiktok.TikTokBusinessSdk.TTConfig;
import com.tiktok.TikTokBusinessSdk.TTInitCallback
import com.tiktok.appevents.base.TTBaseEvent

class CallBack: TTInitCallback {
    override fun success() {
        TODO("Not yet implemented")
    }

    override fun fail(code: Int, msg: String?) {
        TODO("Not yet implemented")
    }

}

class HybridTiktokEventSdk: HybridTiktokEventSdkSpec() {
    override fun initialSdk(accessToken: String, appId: String, tiktokAppId: String): Promise<Boolean> {
        val prs = Promise<Boolean>()
        val config = TTConfig(getApplicationContext(), accessToken).setAppId(appId).setTTAppId(tiktokAppId).enableAutoIapTrack()
        initializeSdk(config, object: TTInitCallback {
            override fun success() {
                prs.resolve(true)
            }

            override fun fail(code: Int, msg: String?) {
                prs.reject(Throwable(msg))
            }

        })
        startTrack()
        return prs
    }

    override fun identifyUser(userId: String, userName: String?, phone: String?, email: String?) {
        identifyUser(userId, userName, phone, email)
    }

    override fun logout() {
        logout()
    }
    
    override fun trackEvent(event: String, params: Map<String, String>?) {
        if (params == null) return
        val eventBuilder = TTBaseEvent.newBuilder(event)
        params.keys.forEach {
            eventBuilder.addProperty(it, params[it])
        }
        trackTTEvent(eventBuilder.build())
    }
}
