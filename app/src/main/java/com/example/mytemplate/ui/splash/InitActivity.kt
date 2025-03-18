package com.example.mytemplate.ui.splash

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.mytemplate.base.BaseActivity
import com.example.mytemplate.databinding.ActivityInitBinding
import com.example.mytemplate.ui.main.MainActivity
import com.example.mytemplate.ui.splash.InitContract.InitEffect
import com.example.mytemplate.ui.splash.InitContract.InitIntent
import com.example.mytemplate.ui.splash.InitContract.InitState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InitActivity : BaseActivity<ActivityInitBinding, InitIntent, InitState, InitEffect, InitViewModel>() {
    override val viewModel: InitViewModel by viewModels()

    private var isReady = false

    override fun inflateViewBinding(): ActivityInitBinding {
        return ActivityInitBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setupSplashScreen()
    }

    override fun initView() {
        processIntent(InitIntent.Initialize)
    }

    override fun renderState(state: InitState) {
        isReady = state.isInitialized

        state.error?.let {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun handleEffect(effect: InitEffect) {
        when (effect) {
            is InitEffect.NavigateToMain -> {
                navigateToMain()
            }
            is InitEffect.ShowError -> {
                Toast.makeText(this, effect.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToMain() {
        startActivity(InitIntent(this, MainActivity::class.java))
        finish()
    }

    private fun setupSplashScreen() {
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                return if (isReady) {
                    content.viewTreeObserver.removeOnPreDrawListener(this)
                    true
                } else {
                    false
                }
            }
        })
    }
}