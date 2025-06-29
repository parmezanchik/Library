package com.first.sloots.library.data.network.api

import com.first.sloots.library.data.network.model.overview.Overview
import retrofit2.Response
import retrofit2.http.GET

interface BookApi {
    @GET("/svc/books/v3/lists/overview.json?api-key=G838JG05P7h4O7K959q2i7aa6gMR8vGe")
    suspend fun getOverview(): Response<Overview>

}