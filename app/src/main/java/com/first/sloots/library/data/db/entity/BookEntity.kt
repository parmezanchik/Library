package com.first.sloots.library.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey(autoGenerate = true) val idKey: Int = 0,
    val title: String,
    val description: String,
    val imageUrl: String,
    val buyUrl: String,
    val categoryId: String,
    val createdDate: String?
)
