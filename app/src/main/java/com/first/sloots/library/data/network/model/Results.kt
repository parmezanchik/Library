package com.first.sloots.library.data.network.model

import com.first.sloots.library.data.network.model.category.ListsItem
import com.google.gson.annotations.SerializedName

data class Results(

	@field:SerializedName("next_published_date")
	val nextPublishedDate: String? = null,

	@field:SerializedName("bestsellers_date")
	val bestsellersDate: String? = null,

	@field:SerializedName("published_date_description")
	val publishedDateDescription: String? = null,

	@field:SerializedName("lists")
	val lists: List<ListsItem?>? = null,

	@field:SerializedName("weekly_uri")
	val weeklyUri: String? = null,

	@field:SerializedName("previous_published_date")
	val previousPublishedDate: String? = null,

	@field:SerializedName("monthly_uri")
	val monthlyUri: String? = null,

	@field:SerializedName("published_date")
	val publishedDate: String? = null
)