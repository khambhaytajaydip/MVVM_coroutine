package com.jai.blueprint.ui.fragment.detailteam

import androidx.lifecycle.MutableLiveData
import com.jai.blueprint.data.model.Player

/**
 * Created by JAI on 19,November,2019
 * JAI KHAMBHAYTA
 */
class PlayerItemViewModel(var movie: Player) {

    var imageUrl = MutableLiveData<String>()

    init {
        imageUrl.value = movie.image_path
    }


}