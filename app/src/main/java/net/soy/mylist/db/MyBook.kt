package net.soy.mylist.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import net.soy.mylist.model.response.BookSearchResponse
import java.util.*

/**
 * Class: MyBook
 * Created by leesoyoung on 2020/06/09.
 *
 * Description: MyBook Entity
 */
@Entity(tableName = "MyBook")
@TypeConverters(Convert::class)
data class MyBook(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "authors") val authors: String,
    @ColumnInfo(name = "datetime") val datetime: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "url") val url : String,
    @ColumnInfo(name = "contents") val contents : String,
    @ColumnInfo(name = "sale_price") val sale_price : String,
    @ColumnInfo(name = "created") val created : Date
) {
    companion object{
        fun to(document: BookSearchResponse.Document): MyBook{
            return MyBook(
                authors = document.authors[0],
                datetime = document.datetime,
                thumbnail = document.thumbnail,
                title = document.title,
                url = document.url,
                contents = document.contents,
                sale_price = document.sale_price.toString(),
                created = Date()
            )
        }
    }
}