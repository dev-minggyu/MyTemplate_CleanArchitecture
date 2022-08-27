package com.example.mytemplate.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.mytemplate.R
import com.example.mytemplate.base.BaseActivity
import com.example.mytemplate.databinding.ActivityInitBinding
import com.example.mytemplate.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InitActivity : BaseActivity<ActivityInitBinding>(R.layout.activity_init) {
    private val _initViewModel: InitViewModel by viewModels()

    private var _isReady = true

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        binding.vm = _initViewModel
        setupSplashScreen()
    }

    private fun gotoMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun setupSplashScreen() {
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (_isReady) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        gotoMain()
                        true
                    } else {
                        false
                    }
                }
            }
    }
}
}