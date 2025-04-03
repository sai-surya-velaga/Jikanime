package com.android.mr.jikanime.server

import com.android.mr.jikanime.data.Anime
import com.android.mr.jikanime.data.AnimeResponse
import com.android.mr.jikanime.data.AnimeResponse2
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {
    @GET("top/anime")
    suspend fun getTopAnime(): Response<AnimeResponse>

    @GET("anime/{anime_id}")
    suspend fun getAnimeDetails(@Path("anime_id") animeId: Int): Response<AnimeResponse2>
}
