package net.soy.mylist.model

import io.reactivex.Single
import net.soy.mylist.KAKAO_API_KEY
import net.soy.mylist.api.SearchServiceApi
import net.soy.mylist.model.request.BookSearchRequest
import net.soy.mylist.model.response.BookSearchResponse

/**
 * Class: NetworkRepositoryImpl
 * Created by leesoyoung on 2020/06/04.
 */
class NetworkRepositoryImpl(private val api : SearchServiceApi): Repository {
    override fun getBookData(bookSearchRequest: BookSearchRequest): Single<BookSearchResponse> {
        return api.searchBook(
            auth = "KakaoAK $KAKAO_API_KEY",
            query = bookSearchRequest.query,
            sort = bookSearchRequest.sort,
            page = bookSearchRequest.page,
            size = bookSearchRequest.size,
            target = bookSearchRequest.target
        )
    }
}