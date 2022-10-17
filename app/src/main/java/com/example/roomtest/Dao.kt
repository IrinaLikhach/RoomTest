package com.example.roomtest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {
    //запись данных в БД
    @Insert
    fun insetrItem(item: Item)
    //получение элементов из базы данных
    @Query("SELECT * FROM items")
    fun getAllItem(): Flow<List<Item>>
}