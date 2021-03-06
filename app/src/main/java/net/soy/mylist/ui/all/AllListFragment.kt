package net.soy.mylist.ui.all

import android.os.Bundle
import android.view.View
import net.soy.mylist.R
import net.soy.mylist.base.BaseFragment
import net.soy.mylist.databinding.FragmentAllListBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * Class: AllListFragment
 * Created by leesoyoung on 2020/06/04.
 *
 * Description: 전체 리스트 화면
 */
class AllListFragment : BaseFragment<FragmentAllListBinding>() {

    override var layoutResId = R.layout.fragment_all_list


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewDataBinding.vm = getViewModel()
        viewDataBinding.lifecycleOwner = this
    }


}