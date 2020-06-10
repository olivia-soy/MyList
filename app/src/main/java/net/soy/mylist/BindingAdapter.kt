package net.soy.mylist

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.soy.mylist.db.MyBook
import net.soy.mylist.model.response.BookSearchResponse
import net.soy.mylist.ui.all.AllListAdapter
import net.soy.mylist.ui.all.AllListViewModel
import net.soy.mylist.ui.my.MyBookAdapter
import net.soy.mylist.ui.my.MyBookViewModel

/**
 * Class: AllListBindingAdapter
 * Created by leesoyoung on 2020/06/09.
 *
 * Description:
 */
@BindingAdapter(value = ["document", "viewModel"])
fun setRepositories(view: RecyclerView, items: List<BookSearchResponse.Document>, vm: AllListViewModel) {
    view.adapter?.run {
        if (this is AllListAdapter) {
            this.documents = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        AllListAdapter(items, vm).apply { view.adapter = this }
    }
}

@BindingAdapter(value = ["imageUrl"])
fun setImageUrl(view: ImageView, url: String){
    Glide.with(view.context).load(url).centerCrop().into(view)
}


@BindingAdapter(value = ["myBook", "viewModel"]) //checkParameterIsNotNull
fun setMyBooks(view: RecyclerView, items: PagedList<MyBook>?, vm: MyBookViewModel) {
    view.adapter?.run {
        if (this is MyBookAdapter) {
            this.submitList(items)
        }
    } ?: run {
        MyBookAdapter(vm).apply {
            view.adapter = this
            this.submitList(items)
        }
    }
}