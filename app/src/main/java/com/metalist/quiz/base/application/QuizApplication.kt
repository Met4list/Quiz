package com.metalist.quiz.base.application

import android.app.Application
import com.metalist.quiz.BuildConfig
import com.metalist.quiz.di.repositoriesModule
import com.metalist.quiz.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class QuizApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidContext(this@QuizApplication)
            modules(
                listOf(
                    repositoriesModule,
                    viewModelsModule
                )
            )
        }
    }
}