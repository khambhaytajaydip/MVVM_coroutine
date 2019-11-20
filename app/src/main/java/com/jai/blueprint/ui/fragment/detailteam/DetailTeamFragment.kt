package com.jai.blueprint.ui.fragment.detailteam

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.jai.blueprint.BR
import com.jai.blueprint.R
import com.jai.blueprint.data.model.Player
import com.jai.blueprint.databinding.FragmentTeamDetailsBinding
import com.jai.blueprint.ui.base.BaseFragment
import com.jai.blueprint.utils.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_team_details.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by JAI on 18,November,2019
 * JAI KHAMBHAYTA
 */
class DetailTeamFragment : BaseFragment<FragmentTeamDetailsBinding, DetailViewModel>() {

    @Inject
    internal lateinit var mViewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var detailViewModel: DetailViewModel
    @Inject
    lateinit var listPlayerData: List<Player>
    @Inject
    lateinit var mPlayerAdapter: PlayerAdapter

    lateinit var mLayoutManager: GridLayoutManager
    var countryId: Int = 0
    @Inject
    lateinit var mGridSpacingItemDecoration: GridSpacingItemDecoration
    private lateinit var fragmentTeamBinding: FragmentTeamDetailsBinding


    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_team_details

    override fun getViewModel(): DetailViewModel {
        return ViewModelProviders.of(this, mViewModelFactory).get(DetailViewModel::class.java)
    }

    override fun getLifeCycleOwner(): LifecycleOwner = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentTeamBinding = getViewDataBinding()

        // set name in title
        setTitle(arguments?.getString("name").toString())
        countryId = arguments?.getInt("id")!!

        // init recyclerview
        setup()

    }

    private fun setup() {
        mLayoutManager = GridLayoutManager(activity!!, 3)
        mLayoutManager.isItemPrefetchEnabled = false
        rvTeamDetails.setHasFixedSize(true)
        rvTeamDetails.layoutManager = mLayoutManager
        rvTeamDetails.addItemDecoration(mGridSpacingItemDecoration)
        rvTeamDetails.itemAnimator = DefaultItemAnimator()


        // call api for data
        detailViewModel.viewModelScope.launch(Dispatchers.Main) {
            if (listPlayerData.isEmpty()) {
                showLoading()
                val data = detailViewModel.fetchPlayerFromRemote()
                if (data.first == 1) {
                    showMessage(data.second)
                }
                hideLoading()
            }

        }

        // load data from local
        detailViewModel.viewModelScope.launch {
            detailViewModel.fetchDataFromDatabase(countryId)
                .observe(this@DetailTeamFragment, Observer {
                    mLayoutManager.reverseLayout = false
                    listPlayerData = it
                    if (listPlayerData.isEmpty()) setEmptyView(true) else setEmptyView()
                    mPlayerAdapter = PlayerAdapter(listPlayerData)
                    rvTeamDetails.adapter = mPlayerAdapter

                })
        }


    }

}
