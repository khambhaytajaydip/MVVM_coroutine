package com.jai.blueprint.utils

/**
 * Created by JAI on 14,November,2019
 * JAI KHAMBHAYTA
 */
sealed class UIState {
    object Loading : UIState()
    object HasData : UIState()
    object Error : UIState()
    class MessageText(text: String) : UIState()
    class MessageRes(val resId: Int) : UIState()
}