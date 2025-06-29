package com.first.sloots.library.data.network.model.overview

import com.first.sloots.library.data.network.model.Results
import com.google.gson.annotations.SerializedName

data class Overview(

    @field:SerializedName("copyright")
	val copyright: String? = null,

    @field:SerializedName("results")
	val results: Results? = null,

    @field:SerializedName("num_results")
	val numResults: Int? = null,

    @field:SerializedName("status")
	val status: String? = null
)