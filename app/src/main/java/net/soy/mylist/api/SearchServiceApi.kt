package net.soy.mylist.api

import io.reactivex.Single
import net.soy.mylist.model.response.BookSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Class: SearchServiceApi
 * Created by leesoyoung on 2020/06/04.
 *
 * Description: 카카오 도서 검색 api
 */
interface SearchServiceApi {

    @GET("/v3/search/book")
    fun searchBook(@Header("Authorization") auth:String,
                   @Query("query") query:String,
                   @Query("sort") sort:String?,
                   @Query("page") page:Int?,
                   @Query("size") size:Int?,
                   @Query("target") target:String?): Single<BookSearchResponse>

}