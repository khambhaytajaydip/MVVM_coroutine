package com.jai.blueprint.ui.fragment.home

import androidx.lifecycle.LiveData
import com.jai.blueprint.data.datamanager.DataManager
import com.jai.blueprint.data.model.ResponseTeam
import com.jai.blueprint.data.model.Team
import com.jai.blueprint.data.network.NetworkResult
import com.jai.blueprint.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

/**
 * Created by JAI on 13,November,2019
 * JAI KHAMBHAYTA
 */
class HomeViewModel @Inject constructor(val dataManager: DataManager) : BaseViewModel(dataManager) {
    suspend fun fetchTeameFromRemote(): Pair<Int, String> {

        return withContext(Dispatchers.IO) {
            var msg: Pair<Int, String>
            if (dataManager.teamDao.getSize() == 0) {
                val data = dataManager.fetchTeamData()
                when ((data as NetworkResult<Any>)) {
                    is NetworkResult.Success<Any> -> {
                        dataManager.insertTeamData(((data as NetworkResult.Success<*>).data as ResponseTeam).data)
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

    suspend fun fetchDataFromDatabase(): LiveData<List<Team>> {
        return withContext(Dispatchers.IO) {
            dataManager.teamDao.fetchAllData()
        }
    }

}
