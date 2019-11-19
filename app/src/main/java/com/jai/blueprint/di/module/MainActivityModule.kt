package com.jai.blueprint.di.module

import androidx.lifecycle.ViewModelProvider
import com.jai.blueprint.data.datamanager.DataManager
import com.jai.blueprint.ui.activity.main.MainViewModel
import com.jai.blueprint.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

/**
 * Created by JAI on 11,November,2019
 * JAI KHAMBHAYTA
 */

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainViewModel(dataManager: DataManager): MainViewModel {
        return MainViewModel(dataManager)
    }

    @Provides
    internal fun mainActivityModelProvider(MainActivity: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(MainActivity)
    }

}