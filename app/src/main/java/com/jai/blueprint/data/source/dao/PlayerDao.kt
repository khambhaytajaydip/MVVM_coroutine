package com.jai.blueprint.data.source.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jai.blueprint.data.model.Player

/**
 * Created by JAI on 18,November,2019
 * JAI KHAMBHAYTA
 */
@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<Player>)

    @Query("SELECT * FROM player WHERE country_id = :id")
    fun fetchAllData(id: Int): LiveData<List<Player>>

    @Query("SELECT * FROM player")
    fun getAllData(): LiveData<List<Player>>


    @Query("SELECT count(*) FROM player")
    fun totalPlayerRecords(): Int

}