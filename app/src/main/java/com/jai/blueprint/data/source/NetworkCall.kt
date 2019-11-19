package com.jai.blueprint.data.source

import com.jai.blueprint.data.model.ResponsePlayers
import com.jai.blueprint.data.model.ResponseTeam
import com.jai.blueprint.utils.AppConstant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * Created by JAI on 11,November,2019
 * JAI KHAMBHAYTA
 */
@Singleton
interface NetworkCall {

//    @POST(AppConstant.API_GET_LOCATION)
//    suspend fun geLocation(): Response<JsonResponse>

//    @GET(AppConstant.API_GET_LOCATION)
//    suspend fun getMostPopular(@Query(API_KEY_QUERY) apiKey: String): Response<MovieResponse>

    @GET(AppConstant.API_TEAMS)
    suspend fun getTeamData(@Query(AppConstant.API_TOKEN_KEY) value: String): Response<ResponseTeam>

    @GET(AppConstant.API_PLAYERS)
    suspend fun getPlayerData(@Query(AppConstant.API_TOKEN_KEY) value: String): Response<ResponsePlayers>



}