package com.jai.blueprint.ui.fragment.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.jai.blueprint.BR
import com.jai.blueprint.data.model.Team
import com.jai.blueprint.databinding.FragmentHomeBinding
import com.jai.blueprint.ui.base.BaseFragment
import com.jai.blueprint.utils.GridSpacingItemDecoration
import com.jai.dadday.util.RecyclerItemClickListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by JAI on 13,November,2019
 * JAI KHAMBHAYTA
 */

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {


    @Inject
    internal lateinit var mViewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var homeViewModel: HomeViewModel
    lateinit var mLayoutManager: GridLayoutManager
    @Inject
    lateinit var mGridSpacingItemDecoration: GridSpacingItemDecoration
    @Inject
    lateinit var mTeamAdapter: TeamAdapter
    @Inject
    lateinit var lisTeamData: List<Team>

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = com.jai.blueprint.R.layout.fragment_home

    override fun getViewModel(): HomeViewModel {
        return ViewModelProviders.of(this, mViewModelFactory).get(HomeViewModel::class.java)
    }

    override fun getLifeCycleOwner(): LifecycleOwner = this


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding = getViewDataBinding()
        setUp()
    }


    private fun setUp() {
        mLayoutManager = GridLayoutManager(activity!!, 3)
        mLayoutManager.isItemPrefetchEnabled = false
        rvTeam.setHasFixedSize(true)
        rvTeam.layoutManager = mLayoutManager
        rvTeam.addItemDecoration(mGridSpacingItemDecoration)
        rvTeam.itemAnimator = DefaultItemAnimator()


        // call api for data
        homeViewModel.viewModelScope.launch(Dispatchers.Main) {
            if (lisTeamData.isEmpty()) {
                showLoading()
                val data = homeViewModel.fetchTeameFromRemote()
                if (data.first == 1) {
                    showMessage(data.second)
                }
                hideLoading()
            }

        }

        // load data from local
        homeViewModel.viewModelScope.launch {
            homeViewModel.fetchDataFromDatabase().observe(this@HomeFragment, Observer {
                mLayoutManager.reverseLayout = false
                lisTeamData = it
                if (lisTeamData.isEmpty()) setEmptyView(true) else setEmptyView()
                mTeamAdapter = TeamAdapter(lisTeamData)
                rvTeam.adapter = mTeamAdapter

            })
        }


        //recycler view click handle
        rvTeam.addOnItemTouchListener(
            RecyclerItemClickListener(
                context!!,
                rvTeam,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        var bundle = bundleOf(
                            "id" to lisTeamData[position].country_id,
                            "name" to lisTeamData[position].name
                        )

                        findNavController().navigate(
                            com.jai.blueprint.R.id.detailTeamFragment,
                            bundle
                        )
                    }
                    override fun onLongItemClick(view: View, position: Int) {
                    }

                })
        )


    }
}
