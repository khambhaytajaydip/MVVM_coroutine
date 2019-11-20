package com.jai.blueprint.ui.activity.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jai.blueprint.BR
import com.jai.blueprint.R
import com.jai.blueprint.databinding.ActivityMainBinding
import com.jai.blueprint.ui.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector


import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import androidx.navigation.fragment.NavHostFragment
import android.view.View
import androidx.navigation.ui.*


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    HasSupportFragmentInjector {


    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var mMainViewModel: MainViewModel
    private lateinit var mActivityMainBinding: ActivityMainBinding
    private lateinit var mContext: Context
    override fun getBindingVariable(): Int = BR.viewModel
    override fun getLayoutId(): Int = R.layout.activity_main
    override fun getViewModel(): MainViewModel = mMainViewModel
    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
        fragmentDispatchingAndroidInjector


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        mActivityMainBinding = getViewDataBinding()
        setupFragment()

    }

    private fun setupFragment() {
        bottomNavigationView.setupWithNavController((container as NavHostFragment)!!.navController)
    }

    fun setTitle(title: String, isBackButton: Boolean = false) {
        tvTitle.text = title
        if (isBackButton) {
            setBackButton()
        } else {
            ic_back.visibility = View.GONE
        }
    }

    fun setBackButton() {
        ic_back.visibility = View.VISIBLE
        ic_back.setOnClickListener {
            onBackPressed()
        }
    }


    /**
     * Setup empatyView when list empty
     */
    fun setEmptyView(isEmpty: Boolean = false) {
        if (isEmpty) {
            emptyList.visibility = View.VISIBLE
        } else {
            emptyList.visibility = View.GONE
        }
    }


}
