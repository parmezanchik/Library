package com.first.sloots.library.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryEntity(
    @PrimaryKey val idKey: String,  // Використовуєш listNameEncoded як id
    val name: String,
    val lastDate: String
)