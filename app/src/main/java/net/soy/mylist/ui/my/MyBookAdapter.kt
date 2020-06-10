package net.soy.mylist.ui.my

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import net.soy.mylist.R
import net.soy.mylist.base.BaseBindingViewHolder
import net.soy.mylist.databinding.ItemMyBookBinding
import net.soy.mylist.db.MyBook

/**
 * Class: MyBookAdapter
 * Created by leesoyoung on 2020/06/10.
 *
 * Description:
 */
class MyBookAdapter(val vm: MyBookViewModel) :
    PagedListAdapter<MyBook, MyBookAdapter.MyBookViewHolder>(object :
        DiffUtil.ItemCallback<MyBook>() {
        override fun areContentsTheSame(oldItem: MyBook, newItem: MyBook) = oldItem.id == newItem.id
        override fun areItemsTheSame(oldItem: MyBook, newItem: MyBook)= oldItem == newItem
    }) {

    companion object {
        private val TAG = MyBookAdapter::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBookViewHolder {
        return MyBookViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_my_book, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyBookViewHolder, position: Int) {
        holder.viewDataBinding.item = getItem(position)
        holder.viewDataBinding.vm = vm
    }

    class MyBookViewHolder(view: View) : BaseBindingViewHolder<ItemMyBookBinding>(view)
}