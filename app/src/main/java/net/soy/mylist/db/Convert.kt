package net.soy.mylist.db

import androidx.room.TypeConverter
import java.util.*

/**
 * Class: Convert
 * Created by leesoyoung on 2020/06/10.
 *
 * Description: date Convert
 */
class Convert {
    @TypeConverter
    fun toDate(value: Long): Date = Date(value)

    @TypeConverter
    fun toLong(date: Date): Long = date.time
}