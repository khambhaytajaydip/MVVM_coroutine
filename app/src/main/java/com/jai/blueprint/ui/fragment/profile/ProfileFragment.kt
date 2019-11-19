package com.jai.blueprint.ui.fragment.profile

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.jai.blueprint.BR
import com.jai.blueprint.R
import com.jai.blueprint.databinding.FragmentProfileBinding
import com.jai.blueprint.ui.base.BaseFragment
import javax.inject.Inject

/**
 * Created by JAI on 15,November,2019
 * JAI KHAMBHAYTA
 */
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    @Inject
    internal lateinit var mViewModelFactory: ViewModelProvider.Factory

    lateinit var fragmentProfileBinding: FragmentProfileBinding

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun getViewModel(): ProfileViewModel =
        ViewModelProviders.of(this, mViewModelFactory).get(ProfileViewModel::class.java)

    override fun getLifeCycleOwner(): LifecycleOwner = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentProfileBinding = getViewDataBinding()
        setUp()
    }

    private fun setUp() {
    }


}