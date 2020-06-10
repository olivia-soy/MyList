package net.soy.mylist.ui.all

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.soy.mylist.NotNullMutableLiveData
import net.soy.mylist.base.BaseViewModel
import net.soy.mylist.db.MyBook
import net.soy.mylist.db.MyBookDao
import net.soy.mylist.model.Repository
import net.soy.mylist.model.request.BookSearchRequest
import net.soy.mylist.model.response.BookSearchResponse
import org.w3c.dom.Document

/**
 * Class: AllListViewModel
 * Created by leesoyoung on 2020/06/04.
 *
 * Description: 전체 리스트 화면의 ViewModel
 */
class AllListViewModel(private val repository: Repository, private val dao: MyBookDao) : BaseViewModel(){

    companion object {
        private val TAG = AllListViewModel::class.java.simpleName
    }

    var query: String  = ""

    private val _bookSearchResponseLiveData = MutableLiveData<BookSearchResponse>()
    val bookSearchResponseLiveData: LiveData<BookSearchResponse>
        get() = _bookSearchResponseLiveData

    private val _documentLiveData: NotNullMutableLiveData<List<BookSearchResponse.Document>> = NotNullMutableLiveData(arrayListOf())
    val documentLiveData: NotNullMutableLiveData<List<BookSearchResponse.Document>>
        get() = _documentLiveData

    fun searchBook(){
        val page = 1
        val bookSearchRequest = BookSearchRequest(query = query, sort = null, page = page, size = null, target = null)

        Log.w(TAG,"bookSearchRequest : $bookSearchRequest")
        addDisposable(repository.getBookData(bookSearchRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    if(documents.size > 0) {
                        Log.d(TAG, "document: $documents")
                        _documentLiveData.value = this.documents
//                        _bookSearchResponseLiveData.postValue(this)
                    }
                    Log.d(TAG, "meta : $meta")
                }
            }, {
                Log.d(TAG, "response error, message : ${it.message}")
            })
        )
    }

    fun addMyBook(document: BookSearchResponse.Document){

        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(MyBook.to(document))
        }

    }
}