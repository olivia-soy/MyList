package net.soy.mylist.ui.all

import android.os.Bundle
import android.view.View
import net.soy.mylist.R
import net.soy.mylist.base.BaseFragment
import net.soy.mylist.databinding.FragmentAllListBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Class: AllListFragment
 * Created by leesoyoung on 2020/06/04.
 *
 * Description: 전체 리스트 화면
 */
class AllListFragment : BaseFragment<FragmentAllListBinding>() {

    override var layoutResId = R.layout.fragment_all_list

    private val allListViewModel: AllListViewModel by viewModel()
    private var page: Int = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewDataBinding.vm = getViewModel()
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.setClickListener {
            allListViewModel.searchBook(page)
        }
    }


}