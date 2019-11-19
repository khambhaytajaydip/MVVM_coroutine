package com.jai.blueprint.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import com.jai.blueprint.R


/**
 * Created by JAI on 14,November,2019
 * JAI KHAMBHAYTA
 */
class AppUtils {

    companion object {
        fun showLoadingDialog(context: Context): ProgressDialog {
            val progressDialog = ProgressDialog(context)
            progressDialog.show()
            if (progressDialog.window != null) {
                progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            progressDialog.setContentView(R.layout.progress_dialog)
            progressDialog.isIndeterminate = true
            progressDialog.setCancelable(false)
            progressDialog.setCanceledOnTouchOutside(false)
            return progressDialog
        }

        fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            if (cm != null) {
                val activeNetwork = cm.activeNetworkInfo
                return activeNetwork != null && activeNetwork.isConnectedOrConnecting
            }
            return false
        }




    }

}