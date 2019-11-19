package com.jai.blueprint.di.module.fragment

import androidx.lifecycle.ViewModelProvider
import com.jai.blueprint.data.datamanager.DataManager
import com.jai.blueprint.ui.fragment.profile.ProfileViewModel
import com.jai.blueprint.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

/**
 * Created by JAI on 15,November,2019
 * JAI KHAMBHAYTA
 */

@Module
class ProfileFragmentModule {
    @Provides
    internal fun provideProfileViewModel(dataManager: DataManager): ProfileViewModel {
        return ProfileViewModel(dataManager)
    }


    @Provides
    fun provideViewModelFactory(profileViewModel: ProfileViewModel): ViewModelProvider.Factory =
        ViewModelProviderFactory(profileViewModel)

}