package com.jai.blueprint.ui.activity.main

import com.jai.blueprint.data.datamanager.DataManager
import com.jai.blueprint.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by JAI on 11,November,2019
 * JAI KHAMBHAYTA
 */
class MainViewModel @Inject constructor(val dataManager: DataManager) : BaseViewModel(dataManager)
