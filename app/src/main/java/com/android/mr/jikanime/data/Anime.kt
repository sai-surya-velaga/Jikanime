package com.android.mr.jikanime.data

import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("data") val animeList: List<Anime>
)

data class AnimeResponse2(
    @SerializedName("data") val anime: Anime
)

data class Anime(
    @SerializedName("mal_id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("synopsis")
    val synopsis: String?,

    @SerializedName("episodes")
    val episodes: Int?,

    @SerializedName("rating")
    val rating: String?,

    @SerializedName("trailer")
    val trailer: Trailer?,

    @SerializedName("images")
    val images: Images?,

    @SerializedName("genres")
    val genres: List<Genre>?
)

data class Images(
    @SerializedName("jpg") val jpg: ImageUrl
)

data class ImageUrl(
    @SerializedName("image_url") val imageUrl: String
)

data class Trailer(
    @SerializedName("url")
    val url: String?
)

data class Genre(
    @SerializedName("name")
    val name: String
)


