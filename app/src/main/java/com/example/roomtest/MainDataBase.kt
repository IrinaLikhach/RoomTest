package com.example.roomtest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class MainDataBase: RoomDatabase() {
    abstract fun getDao(): Dao
    companion object{
        fun getDataBase(context: Context): MainDataBase{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDataBase::class.java,
                "test.db"
            ).build()

        }
    }
}