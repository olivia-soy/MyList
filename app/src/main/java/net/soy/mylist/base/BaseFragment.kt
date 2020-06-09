package net.soy.mylist.base
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T: ViewDataBinding>: Fragment(){

    lateinit var viewDataBinding: T
    abstract var layoutResId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding =  DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return viewDataBinding.root
    }

}