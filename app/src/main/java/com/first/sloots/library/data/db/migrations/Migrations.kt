package com.first.sloots.library.data.db.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val migration_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Створюємо нову таблицю з потрібними колонками
        database.execSQL("""
            CREATE TABLE books_new (
                idKey INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                title TEXT NOT NULL,
                description TEXT NOT NULL,
                imageUrl TEXT NOT NULL,
                buyUrl TEXT NOT NULL,
                categoryId TEXT NOT NULL,
                createdDate TEXT
            )
        """.trimIndent())

        // Переносимо дані зі старої таблиці (без createdDate)
        database.execSQL("""
            INSERT INTO books_new (idKey, title, description, imageUrl, buyUrl, categoryId)
            SELECT idKey, title, description, imageUrl, buyUrl, categoryId FROM books
        """.trimIndent())

        // Видаляємо стару таблицю
        database.execSQL("DROP TABLE books")

        // Перейменовуємо нову таблицю
        database.execSQL("ALTER TABLE books_new RENAME TO books")
    }
}

val migration_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Створюємо нову таблицю з новими полями
        database.execSQL("""
            CREATE TABLE category_new (
                idKey INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                name TEXT NOT NULL,
                lastDate TEXT NOT NULL
            )
        """.trimIndent())

        // Переносимо дані зі старої таблиці якщо треба (немає — пропускаємо)

        // Видаляємо стару таблицю
        database.execSQL("DROP TABLE category")

        // Перейменовуємо нову
        database.execSQL("ALTER TABLE category_new RENAME TO category")
    }
}
