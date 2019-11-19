package com.jai.blueprint.data.source.preference

import android.content.Context
import android.content.SharedPreferences
import com.jai.blueprint.utils.AppConstant
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by JAI on 14,November,2019
 * JAI KHAMBHAYTA
 */
@Singleton
class AppPreferences @Inject constructor(mContext: Context){
    private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"

    private var mPrefs: SharedPreferences = mContext.getSharedPreferences(AppConstant.PREF_NAME, Context.MODE_PRIVATE)

    fun getAccessToken(): String {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null).toString()
    }

    fun setAccessToken(accessToken: String) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply()
    }

}