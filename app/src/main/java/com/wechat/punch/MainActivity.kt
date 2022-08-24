package com.wechat.punch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.wechat.punch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var root: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        root = ActivityMainBinding.inflate(layoutInflater)
        setContentView(root.root)
        initView()
    }

    fun initView() {
        root.button.setOnClickListener {
            if(!AccessibilityWechatPunchService.mIsStart){
                try {
                    startActivity(  Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
                }
                catch (e: Exception){
                    startActivity(  Intent(Settings.ACTION_SETTINGS));
                }

            }

        }
    }
}