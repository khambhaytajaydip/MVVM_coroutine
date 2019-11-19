package com.jai.blueprint.di.component

import android.app.Application
import com.jai.blueprint.BluePrint
import com.jai.blueprint.di.builder.ActivityBuilder
import com.jai.blueprint.di.builder.FragmentBuilder
import com.jai.blueprint.di.module.AppModule
import com.jai.blueprint.di.module.DbModule
import com.jai.blueprint.di.module.NetworkModule
import com.jai.blueprint.di.module.RepoModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by JAI on 11,November,2019
 * JAI KHAMBHAYTA
 */
@Singleton
@Component(modules = [(AndroidInjectionModule::class), (NetworkModule::class), (DbModule::class), (AppModule::class), (RepoModule::class),
    (ActivityBuilder::class),(FragmentBuilder::class)])
interface AppComponent {
    fun inject(bluePrint: BluePrint)
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}