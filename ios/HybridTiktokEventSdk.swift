//
//  HybridTiktokEventSdk.swift
//  Pods
//
//  Created by bachvq on 9/29/2025.
//

import Foundation
import TikTokBusinessSDK
import NitroModules

class HybridTiktokEventSdk: HybridTiktokEventSdkSpec {
    func initialSdk(accessToken: String, appId: String, tiktokAppId: String) throws -> Promise<Bool> {
        let prs = Promise<Bool>.init()
        TikTokBusiness.initializeSdk(.init(accessToken: accessToken, appId: appId, tiktokAppId: tiktokAppId)) { success, err in
            if let err {
                print("TIKTOK INITIAL FAILED", err)
                prs.reject(withError: err)
            } else {
                prs.resolve(withResult: success)
            }
        }
        return prs
    }
    
    func identifyUser(userId: String, userName: String?, phone: String?, email: String?) throws {
        TikTokBusiness.identify(withExternalID: userId, externalUserName: userName, phoneNumber: phone, email: email)
    }
    
    func logout() throws {
        TikTokBusiness.logout()
    }
    
    func trackEvent(event: String, params: Dictionary<String, String>?) throws {
        TikTokBusiness.trackTTEvent(.init(eventName: event, properties: params ?? .init(), eventId: nil))
    }
}
