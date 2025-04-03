package com.android.mr.jikanime

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint

import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.android.mr.jikanime.ui.AnimeAdapter
import com.android.mr.jikanime.ui.AnimeViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val animeViewModel: AnimeViewModel by viewModels()
    private lateinit var animeAdapter: AnimeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAnime)

        animeAdapter = AnimeAdapter(emptyList())
        recyclerView.adapter = animeAdapter

        animeViewModel.animeList.observe(this, Observer { animeList ->
            if (animeList != null) {
                animeAdapter.updateData(animeList)
            } else {
                Log.e("MainActivity", "Failed to load anime list")
            }
        })

        animeViewModel.fetchTopAnime()
    }
}

