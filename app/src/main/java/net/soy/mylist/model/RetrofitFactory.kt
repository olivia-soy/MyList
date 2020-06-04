package net.soy.mylist.model

import net.soy.mylist.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Class: RetrofitFactory
 * Created by leesoyoung on 2020/06/04.
 */
class RetrofitFactory {
    companion object{
        fun build(): Retrofit{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        }
    }
}