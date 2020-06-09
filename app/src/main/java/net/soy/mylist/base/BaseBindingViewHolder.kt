package net.soy.mylist.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingViewHolder<T: ViewDataBinding>(view: View): RecyclerView.ViewHolder(view){

    var viewDataBinding: T = DataBindingUtil.bind(view)!!
}