package com.wechat.punch

import android.accessibilityservice.AccessibilityService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast
import com.blankj.utilcode.util.ToastUtils

class AccessibilityWechatPunchService : AccessibilityService() {


    companion object {
        const val Tag = "AccessibilityWechatPunchService"
        public var mIsStart = false;

        public lateinit var mService: AccessibilityWechatPunchService
    }


    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.e("hhhhhh", "onServiceConnected")
        mIsStart = true
        mService = this

    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event ?: return
        mIsStart = true
        mService = this

        val packageName = event.packageName
        val classNameChr = event.className
        val className = classNameChr?.toString()
        Log.e("kkkkkk", packageName?.toString()?:"null")


        if("com.tencent.wework".equals(packageName) ){//判断是否威企业卫星
            val root =   rootInActiveWindow
//            val node = root.findAccessibilityNodeInfosByViewId("com.alipay.mobile.payee:id/payee_NextBtn")

            performGlobalAction(GLOBAL_ACTION_HOME)
            Log.e("kkkkkk2", "执行")
        }


        ToastUtils.showLong("112")

    }

    override fun onInterrupt() {
        ToastUtils.showLong("onInterrupt")
    }


}