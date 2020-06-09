package net.soy.mylist.db

import androidx.room.*
import javax.sql.DataSource

/**
 * Class: MyBookDao
 * Created by leesoyoung on 2020/06/09.
 *
 * Description:
 * 나의 책 리스트 dao
 */

@Dao
interface MyBookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(myBook: MyBook)

    @Delete
    fun delete(myBook: MyBook)

}