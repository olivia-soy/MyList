package net.soy.mylist.db

import androidx.room.*
import androidx.paging.DataSource

/**
 * Class: MyBookDao
 * Created by leesoyoung on 2020/06/09.
 *
 * Description:
 * 나의 책 리스트 dao
 */

@Dao
interface MyBookDao {

    @Query("SELECT * FROM MyBook ORDER BY created ASC")
    fun getAll(): DataSource.Factory<Int, MyBook>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(myBook: MyBook)

    @Delete
    fun delete(myBook: MyBook)

}