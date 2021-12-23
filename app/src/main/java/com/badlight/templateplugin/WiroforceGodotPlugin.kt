package com.badlight.templateplugin

import android.telephony.SmsManager
import android.util.Log
import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin


class WiroforceGodotPlugin(godot: Godot) : GodotPlugin(godot) {

    override fun getPluginName(): String {
        return "WiroforceGodotPlugin"
    }
    override fun getPluginMethods(): List<String> {
        return listOf(
            "getHelloWorldNative",
            "sendSms"
        )
    }
    fun getHelloWorldNative(): String {
        return "Hello World from Android"
    }

    fun sendSms(number: String, message: String): String? {
        try{
            val smsManager = SmsManager.getDefault() as SmsManager
            smsManager.sendTextMessage(number, null, message, null, null)
            return "Ok"
        }catch(exp: Exception){
            return exp.message?.toString()
        }
    }
}