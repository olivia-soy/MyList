package net.soy.mylist.model.request

import com.google.gson.annotations.Expose

/**
 * Class: BookSearchRequest
 * Created by leesoyoung on 2020/06/04.
 *
 * Description: SearchService api Request 값
 */
data class BookSearchRequest(
    val query : String,
    @Expose val sort : String?,
    @Expose val page : Int?,
    @Expose val size : Int?,
    @Expose val target : String?
)