package com.first.sloots.library.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.first.sloots.library.data.db.dao.BookDao
import com.first.sloots.library.data.db.dao.CategoryDao
import com.first.sloots.library.data.db.entity.BookEntity
import com.first.sloots.library.data.db.entity.CategoryEntity

@Database(
    entities = [
        BookEntity::class,
        CategoryEntity::class
    ],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun categoryDao(): CategoryDao
}