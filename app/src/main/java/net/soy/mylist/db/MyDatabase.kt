package net.soy.mylist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import net.soy.mylist.DB_NAME

/**
 * Class: MyDatabase
 * Created by leesoyoung on 2020/06/09.
 *
 * Description:
 */
@Database(entities = [MyBook::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getMyBookDao(): MyBookDao

    companion object {

        var INSTANCE: MyDatabase? = null
        fun getInstance(context: Context): MyDatabase =
            INSTANCE ?: synchronized(MyDatabase::class) {
                INSTANCE ?: Room.databaseBuilder(
                    context,
                    MyDatabase::class.java,
                    DB_NAME
                )
                        .addMigrations(MIGRATION_1_TO_2)
//                    .fallbackToDestructiveMigration()
                    .build()

            }.also {
                INSTANCE = it
            }


        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }
}