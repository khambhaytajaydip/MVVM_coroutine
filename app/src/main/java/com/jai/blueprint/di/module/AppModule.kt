package com.jai.blueprint.di.module

import android.app.Application
import android.content.Context
import com.jai.blueprint.data.source.preference.AppPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by JAI on 12,November,2019
 * JAI KHAMBHAYTA
 */
@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }


    @Provides
    @Singleton
    internal fun provideAppPreferenece(context: Context): AppPreferences {
        return AppPreferences(context)
    }


//    @Provides
//    @Singleton
//    internal fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
//        return CalligraphyConfig.Builder()
//            .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
//            .setFontAttrId(R.attr.fontPath)
//            .build()
    }


