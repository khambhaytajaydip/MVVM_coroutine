package com.jai.blueprint.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by JAI on 12,November,2019
 * JAI KHAMBHAYTA
 */
abstract class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

    abstract fun onBind(position: Int)
}