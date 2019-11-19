package com.jai.blueprint

import android.app.Activity
import android.app.Application
import com.jai.blueprint.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by JAI on 11,November,2019
 * JAI KHAMBHAYTA
 */

class BluePrint : Application(), HasActivityInjector {
    @Inject
    lateinit var activityDispachingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispachingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }

}
