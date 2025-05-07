package com.example.mytemplate.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytemplate.base.BaseActivity
import com.example.mytemplate.databinding.ActivityMainBinding
import com.example.mytemplate.ui.main.MainContract.MainEffect
import com.example.mytemplate.ui.main.MainContract.MainEvent
import com.example.mytemplate.ui.main.MainContract.MainState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainEvent, MainState, MainEffect, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        binding.btnLoadData.setOnClickListener {
            processEvent(MainEvent.LoadData)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MainAdapter { id ->
            processEvent(MainEvent.ClickItem(id))
        }

        processEvent(MainEvent.LoadData)
    }

    override fun renderState(state: MainState) {
        binding.progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE

        (binding.recyclerView.adapter as? MainAdapter)?.submitList(state.data)

        state.error?.let {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun handleEffect(effect: MainEffect) {
        when (effect) {
            is MainEffect.ShowToast -> {
                Toast.makeText(this, effect.message, Toast.LENGTH_SHORT).show()
            }
            is MainEffect.NavigateToDetail -> {
                Toast.makeText(this, "상세 화면으로 이동: ${effect.id}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}