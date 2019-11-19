package com.jai.blueprint.di.module.fragment

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jai.blueprint.data.datamanager.DataManager
import com.jai.blueprint.data.model.Player
import com.jai.blueprint.ui.fragment.detailteam.DetailViewModel
import com.jai.blueprint.ui.fragment.detailteam.PlayerAdapter
import com.jai.blueprint.ui.fragment.home.HomeFragment
import com.jai.blueprint.utils.GridSpacingItemDecoration
import com.jai.blueprint.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

/**
 * Created by JAI on 18,November,2019
 * JAI KHAMBHAYTA
 */
@Module
class DetailFragmentModule {
    @Provides
    internal fun provideDetailViewModel(dataManager: DataManager): DetailViewModel {
        return DetailViewModel(dataManager)
    }

    @Provides
    internal fun provideGridLayoutManager(fragment: HomeFragment): GridLayoutManager {
        return GridLayoutManager(fragment.activity!!, 3)
    }

    @Provides
    internal fun providelistPlayerData(): List<Player> {
        return mutableListOf()
    }


    @Provides
    internal fun provideGridSpacingItemDecoration(): GridSpacingItemDecoration {
        return GridSpacingItemDecoration(2, 10, true)
    }

    //
    @Provides
    internal fun providePlayerAdpter(): PlayerAdapter{
        return PlayerAdapter(ArrayList())
    }
//


    @Provides
    fun provideViewModelFactory(detailViewModel: DetailViewModel): ViewModelProvider.Factory =
        ViewModelProviderFactory(detailViewModel)

}
