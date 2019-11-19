package com.jai.blueprint.di.module

import android.content.Context
import com.jai.blueprint.data.network.NetworkConnectionInterceptor
import com.jai.blueprint.data.source.NetworkCall
import com.jai.blueprint.utils.AppConstant.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by JAI on 12,November,2019
 * JAI KHAMBHAYTA
 */
@Module
class NetworkModule {
    @Provides
    @Singleton
    internal fun provideNetworkConnectionInterceptor(mContext: Context): NetworkConnectionInterceptor {
        return NetworkConnectionInterceptor(mContext)
    }


    @Provides
    @Singleton
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }


    @Provides
    @Singleton
    internal fun provideMovieApi(retrofit: Retrofit): NetworkCall {
        return retrofit.create(NetworkCall::class.java)
    }

//    @Provides
//    @Singleton
//    internal fun provideTrailerApi(retrofit: Retrofit): TrailerApi {
//        return retrofit.create(TrailerApi::class.java)
//    }


}