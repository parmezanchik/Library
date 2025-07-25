package com.first.sloots.library.data.network.model.books

import com.first.sloots.library.data.db.entity.BookEntity
import com.first.sloots.library.data.network.model.BuyLinksItem
import com.first.sloots.library.data.network.model.IsbnsItem
import com.first.sloots.library.ui.book.model.BooksDM
import com.google.gson.annotations.SerializedName

data class BooksItem(

    @field:SerializedName("isbns")
	val isbns: List<IsbnsItem?>? = null,

    @field:SerializedName("contributor_note")
	val contributorNote: String? = null,

    @field:SerializedName("asterisk")
	val asterisk: Int? = null,

    @field:SerializedName("description")
	val description: String? = null,

    @field:SerializedName("primary_isbn10")
	val primaryIsbn10: String? = null,

    @field:SerializedName("primary_isbn13")
	val primaryIsbn13: String? = null,

    @field:SerializedName("title")
	val title: String? = null,

    @field:SerializedName("article_chapter_link")
	val articleChapterLink: String? = null,

    @field:SerializedName("weeks_on_list")
	val weeksOnList: Int? = null,

    @field:SerializedName("book_image_width")
	val bookImageWidth: Int? = null,

    @field:SerializedName("contributor")
	val contributor: String? = null,

    @field:SerializedName("amazon_product_url")
	val amazonProductUrl: String? = null,

    @field:SerializedName("price")
	val price: String? = null,

    @field:SerializedName("book_uri")
	val bookUri: String? = null,

    @field:SerializedName("rank")
	val rank: Int? = null,

    @field:SerializedName("dagger")
	val dagger: Int? = null,

    @field:SerializedName("age_group")
	val ageGroup: String? = null,

    @field:SerializedName("author")
	val author: String? = null,

    @field:SerializedName("buy_links")
	val buyLinks: List<BuyLinksItem?>? = null,

    @field:SerializedName("sunday_review_link")
	val sundayReviewLink: String? = null,

    @field:SerializedName("book_review_link")
	val bookReviewLink: String? = null,

    @field:SerializedName("book_image_height")
	val bookImageHeight: Int? = null,

    @field:SerializedName("book_image")
	val bookImage: String? = null,

    @field:SerializedName("publisher")
	val publisher: String? = null,

    @field:SerializedName("created_date")
	val createdDate: String? = null,

    @field:SerializedName("updated_date")
	val updatedDate: String? = null,

    @field:SerializedName("rank_last_week")
	val rankLastWeek: Int? = null,

    @field:SerializedName("first_chapter_link")
	val firstChapterLink: String? = null
)



