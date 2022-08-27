package com.example.mytemplate.ui.main

import android.os.Bundle
import com.example.mytemplate.R
import com.example.mytemplate.base.BaseActivity
import com.example.mytemplate.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}