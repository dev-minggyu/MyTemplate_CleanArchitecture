package com.example.mytemplate.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.mytemplate.base.contract.UiEffect
import com.example.mytemplate.base.contract.UiIntent
import com.example.mytemplate.base.contract.UiState
import kotlinx.coroutines.launch

abstract class BaseFragment<T : ViewBinding, I : UiIntent, S : UiState, E : UiEffect, VM : BaseViewModel<I, S, E>> : Fragment() {
    private var _binding: T? = null
    val binding get() = _binding!!

    abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = inflateViewBinding(inflater, container)
        return binding.root
    }

    /**
     * ViewBinding을 inflate하는 추상 메서드
     */
    abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeState()
        observeEffect()
    }

    /**
     * 뷰 초기화 메서드
     */
    abstract fun initView()

    /**
     * State 관찰 메서드
     */
    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    renderState(state)
                }
            }
        }
    }

    /**
     * Effect 관찰 메서드
     */
    private fun observeEffect() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collect { effect ->
                    handleEffect(effect)
                }
            }
        }
    }

    /**
     * State 렌더링 메서드
     */
    abstract fun renderState(state: S)

    /**
     * Effect 처리 메서드
     */
    abstract fun handleEffect(effect: E)

    /**
     * Intent 처리 메서드
     */
    fun processIntent(intent: I) {
        viewModel.processIntent(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}