package com.example.viewmodeldaggerexample

import com.example.viewmodeldaggerexample.di.DaggerAppComponent
import dagger.android.DaggerApplication

class DIApplication: DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.factory().create(applicationContext)
}