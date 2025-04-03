package com.android.mr.jikanime.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.mr.jikanime.AnimeDetailActivity
import com.android.mr.jikanime.R
import com.android.mr.jikanime.data.Anime
import com.bumptech.glide.Glide

class AnimeAdapter(private var animeList: List<Anime>) :
    RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewAnime: ImageView = itemView.findViewById(R.id.imageViewAnime)
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewEpisodes: TextView = itemView.findViewById(R.id.textViewEpisodes)
        val textViewRating: TextView = itemView.findViewById(R.id.textViewRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animeList[position]
        holder.textViewTitle.text = anime.title
        holder.textViewEpisodes.text = "Episodes: ${anime.episodes ?: "N/A"}"
        holder.textViewRating.text = "Rating: ${anime.rating ?: "N/A"}"

        Glide.with(holder.itemView.context)
            .load(anime.images?.jpg?.imageUrl ?: R.drawable.ic_launcher_foreground)
            .into(holder.imageViewAnime)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, AnimeDetailActivity::class.java)
            intent.putExtra("ANIME_ID", anime.id)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = animeList.size

    fun updateData(newList: List<Anime>) {
        animeList = newList
        notifyDataSetChanged()
    }
}
