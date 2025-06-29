package com.first.sloots.library.data.network.model.category

import com.first.sloots.library.data.network.model.books.BooksItem
import com.google.gson.annotations.SerializedName

data class ListsItem(

    @field:SerializedName("books")
	val books: List<BooksItem?>? = null,

    @field:SerializedName("list_id")
	val listId: Int? = null,

    @field:SerializedName("corrections")
	val corrections: List<Any?>? = null,

    @field:SerializedName("normal_list_ends_at")
	val normalListEndsAt: Int? = null,

    @field:SerializedName("list_name")
	val listName: String? = null,

    @field:SerializedName("list_name_encoded")
	val listNameEncoded: String? = null,

    @field:SerializedName("display_name")
	val displayName: String? = null,

    @field:SerializedName("updated")
	val updated: String? = null,

    @field:SerializedName("uri")
	val uri: String? = null
)