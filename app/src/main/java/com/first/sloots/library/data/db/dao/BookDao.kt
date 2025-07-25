package com.first.sloots.library.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.first.sloots.library.data.db.entity.BookEntity

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: BookEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: List<BookEntity>)

    @Query("SELECT * FROM books")
    suspend fun getBooks(): List<BookEntity>

    @Query("SELECT * FROM books WHERE idKey = :id")
    suspend fun getBookById(id: Int): BookEntity?

    @Query("SELECT * FROM books WHERE categoryId = :categoryId")
    suspend fun getBooksByCategory(categoryId: String): List<BookEntity>

    @Query("DELETE FROM books WHERE categoryId = :categoryId")
    suspend fun deleteBooksByCategory(categoryId: String)
}
