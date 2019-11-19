package com.jai.blueprint.data.model

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by JAI on 18,November,2019
 * JAI KHAMBHAYTA
 */

data class ResponsePlayers(
    val data: MutableList<Player>
)

@Entity(tableName = "player")
data class Player(
    var country_id: Int = 0,
    var dateofbirth: String = "",
    var firstname: String = "",
    var fullname: String = "",
    var gender: String = "",
    @PrimaryKey
    var id: Int = 0,
    var image_path: String = "",
    var lastname: String = "",
    @TypeConverters(PositionConverters::class)
    var position: Position,
    var resource: String = "",
    var updated_at: String = ""
)


data class Position(
    var id: Int = 0,
    var name: String = "",
    var resource: String = ""
)


class PositionConverters {
    /**
     * Convert Position to String
     */
    @TypeConverter
    fun positionToString (stat: Position): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a position
     */
    @TypeConverter
    fun fromPosition(jsonImages: String): Position {
        val notesType = object : TypeToken<Position>() {}.type
        return Gson().fromJson<Position>(jsonImages, notesType)
    }
}