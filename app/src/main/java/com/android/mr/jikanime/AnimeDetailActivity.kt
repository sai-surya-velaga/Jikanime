package com.android.mr.jikanime

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.android.mr.jikanime.ui.AnimeDetailsViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailActivity : AppCompatActivity() {

    private val viewModel: AnimeDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_detail)

        val animeId = intent.getIntExtra("ANIME_ID", -1)
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        val textViewEpisodes = findViewById<TextView>(R.id.textViewEpisodes)
        val textViewRating = findViewById<TextView>(R.id.textViewRating)
        val imageViewAnime = findViewById<ImageView>(R.id.imageViewAnime)
        val btnWatchTrailer = findViewById<Button>(R.id.btnWatchTrailer)

        if (animeId != -1) {
            viewModel.fetchAnimeDetails(animeId)
        }

        viewModel.animeDetails.observe(this) { anime ->
            anime?.let {
                textViewTitle.text = it.title
                textViewEpisodes.text = "Episodes: ${it.episodes ?: "N/A"}"
                textViewRating.text = "Rating: ${it.rating ?: "N/A"}"

                Glide.with(this)
                    .load(it.images?.jpg?.imageUrl)
                    .into(imageViewAnime)

                // Handle trailer button
                it.trailer?.url?.let { trailerUrl ->
                    btnWatchTrailer.visibility = View.VISIBLE
                    btnWatchTrailer.setOnClickListener {
                        openTrailer(trailerUrl)
                    }
                } ?: run {
                    btnWatchTrailer.visibility = View.GONE
                }
            }
        }
    }

    private fun openTrailer(trailerUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(trailerUrl))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}
