package com.jai.blueprint.di.module.activity

import androidx.lifecycle.ViewModelProvider
import com.jai.blueprint.data.datamanager.DataManager
import com.jai.blueprint.ui.activity.splash.SplashViewModel
import com.jai.blueprint.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

/**
 * Created by JAI on 18,November,2019
 * JAI KHAMBHAYTA
 */
@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplasViewModel(dataManager: DataManager): SplashViewModel {
        return SplashViewModel(dataManager)
    }

    @Provides
    internal fun mainActivityModelProvider(splashViewModel: SplashViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(splashViewModel)
    }


}