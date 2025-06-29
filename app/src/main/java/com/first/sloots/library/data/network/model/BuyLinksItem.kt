package com.first.sloots.library.data.network.model

import com.google.gson.annotations.SerializedName

data class BuyLinksItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)