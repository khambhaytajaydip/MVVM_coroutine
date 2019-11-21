package com.jai.blueprint.data.datamanager

import com.jai.blueprint.data.model.Player
import com.jai.blueprint.data.model.Team
import com.jai.blueprint.data.source.NetworkCall
import com.jai.blueprint.data.source.dao.PlayerDao
import com.jai.blueprint.data.source.dao.TeamDao
import com.jai.blueprint.ui.base.BaseRepository
import com.jai.blueprint.utils.AppConstant
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by JAI on 11,November,2019
 * JAI KHAMBHAYTA
 */

@Singleton
class DataManager @Inject constructor(
    val teamDao: TeamDao,
    val playerDao: PlayerDao,
    val networkCall: NetworkCall
) : BaseRepository() {

    /**
     * API call
     */

    suspend fun fetchTeamData(): Any {
        val data =
            safeApiCall({ networkCall.getTeamData(AppConstant.API_TOKEN_VALUE) }, "No response")
        return data!!
    }

    suspend fun fetchPlayerData(): Any {
        val data =
            safeApiCall({ networkCall.getPlayerData(AppConstant.API_TOKEN_VALUE) }, "No response")
        return data!!
    }


    /**
     * DATABASE Manage
     */

   fun insertTeamData(data: MutableList<Team>): Any {
        val result = teamDao.insertAll(data)
        teamDao.updateData()
        return result
    }

    fun insertPlayerData(data: MutableList<Player>): Any {
        val result = playerDao.insertAll(data)
        return result
    }


}