package com.jai.blueprint.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jai.blueprint.data.model.Player
import com.jai.blueprint.data.model.PositionConverters
import com.jai.blueprint.data.model.Team
import com.jai.blueprint.data.source.dao.PlayerDao
import com.jai.blueprint.data.source.dao.TeamDao
import javax.inject.Singleton

/**
 * Created by JAI on 12,November,2019
 * JAI KHAMBHAYTA
 */
@Singleton
@Database(entities = [Team::class, Player::class], version = 1, exportSchema = false)
@TypeConverters(PositionConverters::class)
abstract class LocalDb : RoomDatabase() {
    abstract fun teamDao(): TeamDao
    abstract fun playerDao(): PlayerDao
}
