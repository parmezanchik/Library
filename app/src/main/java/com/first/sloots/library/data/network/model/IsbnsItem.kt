package com.first.sloots.library.data.network.model

import com.google.gson.annotations.SerializedName

data class IsbnsItem(

	@field:SerializedName("isbn13")
	val isbn13: String? = null,

	@field:SerializedName("isbn10")
	val isbn10: String? = null
)