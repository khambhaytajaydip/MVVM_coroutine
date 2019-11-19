package com.jai.blueprint.ui.fragment.home

import androidx.lifecycle.MutableLiveData
import com.jai.blueprint.data.model.Team

/**
 * Created by JAI on 15,November,2019
 * JAI KHAMBHAYTA
 */
class TeamItemViewModel(var movie: Team, var mListener: MovieItemViewModelListener) {

    var imageUrl = MutableLiveData<String>()

    init {
        imageUrl.value = movie.image_path
    }

    fun onItemClick() {
        mListener.onItemClick(movie)
    }


    interface MovieItemViewModelListener {
        fun onItemClick(movie: Team)
    }
}