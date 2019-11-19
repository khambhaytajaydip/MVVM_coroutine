package com.jai.blueprint.di.builder

import com.jai.blueprint.di.module.fragment.DetailFragmentModule
import com.jai.blueprint.di.module.fragment.HomeFragmentModule
import com.jai.blueprint.di.module.fragment.ProfileFragmentModule
import com.jai.blueprint.ui.fragment.detailteam.DetailTeamFragment
import com.jai.blueprint.ui.fragment.home.HomeFragment
import com.jai.blueprint.ui.fragment.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by JAI on 13,November,2019
 * JAI KHAMBHAYTA
 */
@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector(modules = [(HomeFragmentModule::class)])
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [(ProfileFragmentModule::class)])
    abstract fun bindProfileFragment(): ProfileFragment

    @ContributesAndroidInjector(modules = [(DetailFragmentModule::class)])
    abstract fun bindDetailTeamFragment(): DetailTeamFragment
}