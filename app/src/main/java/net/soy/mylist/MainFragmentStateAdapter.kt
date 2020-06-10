package net.soy.mylist

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import net.soy.mylist.ui.all.AllListFragment
import net.soy.mylist.ui.my.MyBookFragment
import java.lang.IndexOutOfBoundsException

/**
 * Class: MainFragmentStateAdapter
 * Created by leesoyoung on 2020/06/04.
 *
 * Description: fragment state adapter
 */
class MainFragmentStateAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount() =  tabFragments.size

    private val tabFragments: Map<Int, () -> Fragment> = mapOf(
        ALL_LIST_INDEX to { AllListFragment() },
        MY_LIST_INDEX to { MyBookFragment() }
    )

    override fun createFragment(position: Int) = tabFragments[position]?.invoke() ?: throw IndexOutOfBoundsException()
}