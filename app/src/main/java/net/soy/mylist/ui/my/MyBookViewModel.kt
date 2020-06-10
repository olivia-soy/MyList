package net.soy.mylist.ui.my

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.soy.mylist.base.BaseViewModel
import net.soy.mylist.db.MyBook
import net.soy.mylist.db.MyBookDao

/**
 * Class: MyBookViewModel
 * Created by leesoyoung on 2020/06/10.
 *
 * Description: 나의 책 리스트 화면의 viewModel
 */
class MyBookViewModel(private val dao: MyBookDao): BaseViewModel(){

    val myBook : LiveData<PagedList<MyBook>> = LivePagedListBuilder(dao.getAll(), 10).build()

    fun deleteMyBook(myBook: MyBook) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.delete(myBook)
        }
    }
}