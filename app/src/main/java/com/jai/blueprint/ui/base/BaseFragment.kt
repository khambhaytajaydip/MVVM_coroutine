package com.jai.blueprint.ui.base

import OnOneOffClickListener
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.jai.blueprint.R
import com.jai.blueprint.databinding.FragmentHomeBinding
import com.jai.blueprint.ui.activity.main.MainActivity
import com.jai.blueprint.ui.fragment.home.HomeViewModel
import com.jai.blueprint.ui.fragment.profile.ProfileViewModel
import dagger.android.support.AndroidSupportInjection

/**
 * Created by JAI on 12,November,2019
 * JAI KHAMBHAYTA
 */
abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {

    var mActivity: BaseActivity<T, V>? = null
    lateinit var mRootView: View
    lateinit var mViewDataBinding: T
    lateinit var mViewModel: V
    abstract fun getBindingVariable(): Int
    abstract fun getLayoutId(): Int
    abstract fun getViewModel(): V
    abstract fun getLifeCycleOwner(): LifecycleOwner
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            val activity = context
            mActivity = activity as BaseActivity<T, V>?
            mActivity?.onFragmentAttached()
        }
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mRootView = mViewDataBinding.root
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding.setVariable(getBindingVariable(), getViewModel())
        mViewDataBinding.lifecycleOwner = getLifeCycleOwner()
        mViewDataBinding.executePendingBindings()


        // setup title
        when (getViewModel()) {
            is HomeViewModel -> {
                (activity as MainActivity).setTitle(getString(R.string.title_home))
            }

            is ProfileViewModel -> {
                (activity as MainActivity).setTitle(getString(R.string.title_profile))
            }

            else -> {
                (activity as MainActivity).setTitle(getString(R.string.app_name))
            }
        }

    }

    fun setTitle(tile: String){
        (activity as MainActivity).setTitle(tile,true)
    }

    fun setEmptyView(isEmpaty: Boolean = false) {
        (activity as MainActivity).setEmptyView(isEmpaty)
    }

    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }

    fun getBaseActivity(): BaseActivity<T, V>? = mActivity

    fun getViewDataBinding(): T = mViewDataBinding

    fun showLoading() = mActivity?.showLoading()

    fun hideLoading() = mActivity?.hideLoading()

    fun hideKeyboard() = mActivity?.hideKeyboard()

    fun isNetworkConnected(): Boolean = mActivity != null && mActivity!!.isNetworkConnected()

    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

    fun showMessage(message: String) {
        mActivity?.showMessage(message)
    }

    fun onError(message: String?) {
        mActivity?.onError(message)
    }

    /**
     * prevent double click on view
     **/
    fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
        try {
            val safeClickListener = OnOneOffClickListener {
                onSafeClick(it)
            }
            setOnClickListener(safeClickListener)
        } catch (E: Exception) {
        }
    }
}
