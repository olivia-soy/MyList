package net.soy.mylist.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.soy.mylist.base.BaseViewModel
import net.soy.mylist.model.Repository
import net.soy.mylist.model.request.BookSearchRequest
import net.soy.mylist.model.response.BookSearchResponse

/**
 * Class: AllListViewModel
 * Created by leesoyoung on 2020/06/04.
 *
 * Description: 전체 리스트 화면의 ViewModel
 */
class AllListViewModel(private val repository: Repository) : BaseViewModel(){

    companion object {
        private val TAG = AllListViewModel::class.java.simpleName
    }

    var query: String  = ""

    private val _bookSearchResponseLiveData = MutableLiveData<BookSearchResponse>()
    val bookSearchResponseLiveData: LiveData<BookSearchResponse>
        get() = _bookSearchResponseLiveData

    fun searchBook(page: Int){
        val bookSearchRequest = BookSearchRequest(query = query, sort = null, page = page, size = null, target = null)

        Log.w(TAG,"bookSearchRequest : $bookSearchRequest")
        addDisposable(repository.getBookData(bookSearchRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    if(documents.size > 0) {
                        Log.d(TAG, "document: $documents")
                        _bookSearchResponseLiveData.postValue(this)
                    }
                    Log.d(TAG, "meta : $meta")
                }
            }, {
                Log.d(TAG, "response error, message : ${it.message}")
            })
        )
    }
}