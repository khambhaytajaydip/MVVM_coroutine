package com.jai.blueprint.data.source.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jai.blueprint.data.model.Team

/**
 * Created by JAI on 15,November,2019
 * JAI KHAMBHAYTA
 */
@Dao
interface TeamDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<Team>)

    @Query("SELECT * FROM team")
    fun fetchAllData(): LiveData<List<Team>>

    @Query("SELECT count(*) from team")
    fun getSize():Int


    @Transaction
    fun updateData() {
        // this is just for data update because of random country id in response
        // we can use common method for update and pass parameter of id and code intent doing this.
        updateIndia()
        updatePak()
        updateAus()
        updateBGB()
        updateENG()
        updateLNK()
        updateZAF()
        updateNZL()
        updateWI()
        updateZIm()
    }

    @Query("UPDATE team set country_id = 2325 where code like 'ZIM'")
    fun updateZIm()

    @Query("UPDATE team set country_id = 24150873 where code like 'WI'")
    fun updateWI()

    @Query("UPDATE team set country_id = 2817 where code like 'NZL'")
    fun updateNZL()

    @Query("UPDATE team set country_id = 146 where code like 'ZAF'")
    fun updateZAF()

    @Query(" UPDATE team set country_id = 38404 where code like 'LKA'")
    fun updateLNK()

    @Query("UPDATE team set country_id = 462 where code like 'ENG'")
    fun updateENG()

    @Query("UPDATE team set country_id = 155043 where code like 'BGD'")
    fun updateBGB()

    @Query("UPDATE team set country_id = 98 where code like 'AUS'")
    fun updateAus()

    @Query("UPDATE team set country_id = 52126 where code like 'PAK'")
    fun updatePak()

    @Query("Update team set country_id=153732 where code like 'IND'")
    fun updateIndia()


}