package com.jai.blueprint.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ResponseTeam(
    val data: MutableList<Team>
)

@Entity(tableName = "team")
data class Team(
    val code: String? = "",
    val country_id: Int = 0,
    @PrimaryKey
    val id: Int = 0,
    val image_path: String = "",
    val name: String = "",
    val national_team: Boolean = false,
    val resource: String = "",
    val updated_at: String = ""
)
