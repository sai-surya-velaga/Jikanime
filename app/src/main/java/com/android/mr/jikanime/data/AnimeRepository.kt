package com.android.mr.jikanime.data


import com.android.mr.jikanime.server.AnimeApiService
import javax.inject.Inject

interface AnimeRepository {
    suspend fun getTopAnime(): List<Anime>
    suspend fun getAnimeDetails(animeId: Int): Anime?
}

class AnimeRepositoryImpl @Inject constructor(
    private val apiService: AnimeApiService
) : AnimeRepository {
    override suspend fun getTopAnime(): List<Anime> {
        val response = apiService.getTopAnime()
        return if (response.isSuccessful) response.body()?.animeList ?: emptyList() else emptyList()
    }

    override suspend fun getAnimeDetails(animeId: Int): Anime? {
        val response = apiService.getAnimeDetails(animeId)
        return if (response.isSuccessful) response.body()?.anime else null
    }
}
