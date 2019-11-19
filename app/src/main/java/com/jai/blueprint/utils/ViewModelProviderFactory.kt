package com.jai.blueprint.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by JAI on 12,November,2019
 * JAI KHAMBHAYTA
 */
class ViewModelProviderFactory<V : Any>(private var viewModel: V) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel.javaClass)) {
            return  viewModel as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}

//class ViewModelProviderFactory<V : kotlin.Any> public constructor(val viewModel: V) : androidx.lifecycle.ViewModelProvider.Factory {
////    private final lateinit var viewModel: V /* compiled code */
//
//    public override fun <T : androidx.lifecycle.ViewModel?> create(modelClass: java.lang.Class<T>): T {
//        if (modelClass.isAssignableFrom(viewModel.javaClass)) {
//            return viewModel as T
//        }
////
//            throw IllegalArgumentException("Unknown class name")
//
//
//        }}