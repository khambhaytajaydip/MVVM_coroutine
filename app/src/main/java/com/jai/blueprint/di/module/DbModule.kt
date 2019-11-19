package com.jai.blueprint.di.module

import android.content.Context
import androidx.room.Room
import com.jai.blueprint.data.source.LocalDb
import com.jai.blueprint.data.source.dao.PlayerDao
import com.jai.blueprint.data.source.dao.TeamDao
import com.jai.blueprint.utils.AppConstant
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by JAI on 12,November,2019
 * JAI KHAMBHAYTA
 */
@Module
class DbModule {
    //
    @Provides
    @Singleton
    internal fun provideDb(context: Context): LocalDb {
        return Room.databaseBuilder(context, LocalDb::class.java, AppConstant.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    internal fun provideTeamDao(context: Context): TeamDao {
        return provideDb(context).teamDao()
    }


    @Provides
    @Singleton
    internal fun providePlayerDao(context: Context): PlayerDao {
        return provideDb(context).playerDao()
    }

}