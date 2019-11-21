package com.jai.blueprint.ui.fragment.detailteam

import androidx.lifecycle.LiveData
import com.jai.blueprint.data.datamanager.DataManager
import com.jai.blueprint.data.model.Player
import com.jai.blueprint.data.model.ResponsePlayers
import com.jai.blueprint.data.network.NetworkResult
import com.jai.blueprint.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

/**
 * Created by JAI on 18,November,2019
 * JAI KHAMBHAYTA
 */
class DetailViewModel @Inject constructor(val dataManager: DataManager) :
    BaseViewModel(dataManager) {

    suspend fun fetchPlayerFromRemote(): Pair<Int, String> {

        return withContext(Dispatchers.IO) {
            var msg: Pair<Int, String>
            val isData = dataManager.playerDao.totalPlayerRecords()
            if (isData == 0) {
                val data = dataManager.fetchPlayerData()
                when ((data as NetworkResult<Any>)) {
                    is NetworkResult.Success<Any> -> {
                        dataManager.insertPlayerData(((data as NetworkResult.Success<*>).data as ResponsePlayers).data)
                        msg = Pair(0, "")
                    }
                    // error in api calling
                    is NetworkResult.Error -> {
                        msg = Pair(
                            1,
                            ((data as NetworkResult.Error).error as IOException).message.toString()
                        )
                    }
                }
                msg
            }
            msg = Pair(0, "")
            msg
        }
    }


    suspend fun fetchDataFromDatabase(id: Int): LiveData<List<Player>> {
        return withContext(Dispatchers.IO) {
            dataManager.playerDao.fetchAllData(id)
        }
    }


}