package com.jai.blueprint.data.network

import java.io.IOException

/**
 * Created by JAI on 14,November,2019
 * JAI KHAMBHAYTA
 */
class NoConnectivityException : IOException() {

    // You can send any message whatever you want from here.
    override val message: String
        get() = "No Internet Connection"
}