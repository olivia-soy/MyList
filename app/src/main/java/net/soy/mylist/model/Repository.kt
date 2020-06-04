package net.soy.mylist.model

import io.reactivex.Single
import net.soy.mylist.model.request.BookSearchRequest
import net.soy.mylist.model.response.BookSearchResponse

/**
 * Class: Repository
 * Created by leesoyoung on 2020/06/04.
 */
interface Repository {
    fun getBookData(bookSearchRequest: BookSearchRequest): Single<BookSearchResponse>
}