package net.soy.mylist.ui.all

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.soy.mylist.model.response.BookSearchResponse

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
    view.setImageURI(Uri.parse(url))
}