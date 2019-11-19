package com.jai.blueprint.di.builder

import com.jai.blueprint.ui.activity.main.MainActivity
import com.jai.blueprint.di.module.MainActivityModule
import com.jai.blueprint.di.module.activity.SplashActivityModule
import com.jai.blueprint.ui.activity.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by JAI on 11,November,2019
 * JAI KHAMBHAYTA
 */
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    internal abstract fun bindSplashActivity(): SplashActivity

}


