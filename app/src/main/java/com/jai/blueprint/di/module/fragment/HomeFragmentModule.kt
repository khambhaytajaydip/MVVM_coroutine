package com.jai.blueprint.di.module.fragment

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jai.blueprint.data.datamanager.DataManager
import com.jai.blueprint.data.model.Team
import com.jai.blueprint.ui.fragment.home.HomeFragment
import com.jai.blueprint.ui.fragment.home.HomeViewModel
import com.jai.blueprint.ui.fragment.home.TeamAdapter
import com.jai.blueprint.utils.GridSpacingItemDecoration
import com.jai.blueprint.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

/**
 * Created by JAI on 13,November,2019
 * JAI KHAMBHAYTA
 */
@Module
class HomeFragmentModule {

    @Provides
    internal fun provideHomeViewModel(dataManager: DataManager): HomeViewModel {
        return HomeViewModel(dataManager)
    }

    @Provides
    internal fun provideGridLayoutManager(fragment: HomeFragment): GridLayoutManager {
        return GridLayoutManager(fragment.activity!!, 3)
    }

    @Provides
    internal fun providelistteamData(): List<Team> {
        return mutableListOf()
    }


    @Provides
    internal fun provideGridSpacingItemDecoration(): GridSpacingItemDecoration {
        return GridSpacingItemDecoration(2, 10, true)
    }

    //
    @Provides
    internal fun provideTeamAdapter(): TeamAdapter {
        return TeamAdapter(ArrayList())
    }
//


    @Provides
    fun provideViewModelFactory(homeViewModel: HomeViewModel): ViewModelProvider.Factory =
        ViewModelProviderFactory(homeViewModel)


}