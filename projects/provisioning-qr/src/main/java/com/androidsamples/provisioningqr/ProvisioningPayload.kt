package com.androidsamples.provisioningqr

import org.json.JSONObject

data class ProvisioningPayload(
    val deviceAdmin: String,
    val wifiSsid: String,
    val wifiPassword: String,
    val organizationName: String
) {
    fun toJson(): String {
        val json = JSONObject()
        json.put("android.app.extra.PROVISIONING_DEVICE_ADMIN_COMPONENT_NAME", deviceAdmin)
        json.put("android.app.extra.PROVISIONING_WIFI_SSID", wifiSsid)
        json.put("android.app.extra.PROVISIONING_WIFI_PASSWORD", wifiPassword)
        json.put("android.app.extra.PROVISIONING_ORGANIZATION_NAME", organizationName)
        return json.toString()
    }

    companion object {
        fun default() = ProvisioningPayload(
            deviceAdmin = "com.androidsamples.policycontroller/.AdminReceiver",
            wifiSsid = "EnterpriseWiFi",
            wifiPassword = "Password123",
            organizationName = "AndroidSamples Enterprise"
        )
    }
}
