package net.soy.mylist.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import net.soy.mylist.model.response.BookSearchResponse

/**
 * Class: MyBook
 * Created by leesoyoung on 2020/06/09.
 *
 * Description: MyBook Entity
 */
@Entity(tableName = "MyBook")
data class MyBook(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "authors") val authors: String,
    @ColumnInfo(name = "datetime") val datetime: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "url") val url : String,
    @ColumnInfo(name = "contents") val contents : String
) {
    companion object{
        fun to(document: BookSearchResponse.Document): MyBook{
            return MyBook(
                authors = document.authors[0],
                datetime = document.datetime,
                thumbnail = document.thumbnail,
                title = document.title,
                url = document.url,
                contents = document.contents
            )
        }
    }
}