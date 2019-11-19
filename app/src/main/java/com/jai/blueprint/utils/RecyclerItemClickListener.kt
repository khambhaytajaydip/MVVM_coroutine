package com.jai.dadday.util

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by JAI on 13,June,2019
 * JAI KHAMBHAYTA
 * https://stackoverflow.com/questions/24471109/recyclerview-onclick/56580557#56580557
 *
 */


class RecyclerItemClickListener(context: Context, recyclerView: RecyclerView, listner: OnItemClickListener) : RecyclerView.OnItemTouchListener {
    var mGestureDetector: GestureDetector
    var mListner: OnItemClickListener
    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onLongItemClick(view: View, position: Int)
    }
    init {
        this.mListner = listner
        mGestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                return true
            }
            override fun onLongPress(e: MotionEvent?) {
                val child: View? = recyclerView.findChildViewUnder(e!!.getX(), e.getY())
                if (child != null && mListner != null) {
                    mListner.onLongItemClick(child, recyclerView.getChildAdapterPosition(child))
                }

            }

        })
    }
    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
    }

    override fun onInterceptTouchEvent(view: RecyclerView, e: MotionEvent): Boolean {
        val childView: View? = view.findChildViewUnder(e!!.getX(), e.getY())
        if (childView != null && mListner != null && mGestureDetector.onTouchEvent(e)) {
            mListner.onItemClick(childView, view.getChildAdapterPosition(childView))
            return true
        }
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }

}