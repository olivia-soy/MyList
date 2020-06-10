package net.soy.mylist.ui.my

import android.os.Bundle
import android.view.View
import net.soy.mylist.R
import net.soy.mylist.base.BaseFragment
import net.soy.mylist.databinding.FragmentMyBookBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * Class: MyBookFragment
 * Created by leesoyoung on 2020/06/09.
 *
 * Description: 나의 책 리스트 화면
 */
class MyBookFragment : BaseFragment<FragmentMyBookBinding>() {

    override var layoutResId = R.layout.fragment_my_book

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.vm = getViewModel()
        viewDataBinding.lifecycleOwner = this
    }


}