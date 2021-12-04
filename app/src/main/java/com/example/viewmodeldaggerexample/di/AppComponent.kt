package com.example.viewmodeldaggerexample.di

import android.content.Context
import com.example.viewmodeldaggerexample.DIApplication
import com.example.viewmodeldaggerexample.ViewModelFactory
import com.example.viewmodeldaggerexample.main.MainActivity
import com.example.viewmodeldaggerexample.main.MainViewModel
import com.example.viewmodeldaggerexample.main.MainViewModelImpl
import dagger.*
import dagger.android.*
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MainActivityScope


@AppScope
@Component(modules = [AppModule::class])
interface AppComponent: AndroidInjector<DIApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}

@Module(includes = [AndroidInjectionModule::class])
interface AppModule {
    @MainActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun mainActivity(): MainActivity
}

@Module
interface MainActivityModule {
    companion object {
        @Provides
        fun provideViewModelFactory(viewModel: MainViewModel) = ViewModelFactory(viewModel)
    }

    @Binds
    fun bindViewModel(impl: MainViewModelImpl): MainViewModel
}