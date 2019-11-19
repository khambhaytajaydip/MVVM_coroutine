package com.jai.blueprint.data.work

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.jai.blueprint.data.datamanager.DataManager

/**
 * Created by JAI on 12,November,2019
 * JAI KHAMBHAYTA
 */
class DaggerWorkerFactory(private val dataManager: DataManager) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        val workerKlass = Class.forName(workerClassName).asSubclass(ListenableWorker::class.java)
        val constructor =
            workerKlass.getDeclaredConstructor(Context::class.java, WorkerParameters::class.java)
        val instance = constructor.newInstance(appContext, workerParameters)

        when (instance) {
            is RefreshMoviesWork -> {
                instance.dataManager = dataManager
            }
            // optionally, handle other workers
        }

        return instance
    }
}