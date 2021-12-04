package com.example.viewmodeldaggerexample.main

import android.os.Bundle
import com.example.viewmodeldaggerexample.R
import dagger.android.support.DaggerAppCompatActivity
import androidx.activity.viewModels
import com.example.viewmodeldaggerexample.ViewModelFactory
import javax.inject.Inject

class MainActivity: DaggerAppCompatActivity() {
    @Inject lateinit var realViewModel: ViewModelFactory<MainViewModel>

    private val viewModel: MainViewModel by viewModels {
        realViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.testVar
        viewModel.test()
    }
}