package com.example.viewmodeldaggerexample.main

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class MainViewModel: ViewModel() {
    abstract var testVar: Boolean

    abstract fun test()
}

class MainViewModelImpl @Inject constructor(): MainViewModel() {
    override var testVar = true

    override fun test() {
        Log.d("MainViewModelImpl", "It's working")
    }
}