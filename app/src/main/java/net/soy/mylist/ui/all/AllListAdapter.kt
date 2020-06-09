package net.soy.mylist.ui.all

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.soy.mylist.R
import net.soy.mylist.base.BaseBindingViewHolder
import net.soy.mylist.databinding.ItemAllBinding
import net.soy.mylist.model.response.BookSearchResponse

/**
 * Class: AllListAdapter
 * Created by leesoyoung on 2020/06/09.
 *
 * Description:
 */
class AllListAdapter(var documents: List<BookSearchResponse.Document>, var vm: AllListViewModel): RecyclerView.Adapter<AllListAdapter.AllListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllListViewHolder {
        return AllListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_all, parent, false))
    }

    override fun onBindViewHolder(holder: AllListViewHolder, position: Int) {
        holder.viewDataBinding.item = documents[position]
        holder.viewDataBinding.vm = vm
    }
    override fun getItemCount(): Int = documents.size
    class AllListViewHolder(view: View) : BaseBindingViewHolder<ItemAllBinding>(view)
}