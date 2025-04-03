package com.android.mr.jikanime.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.mr.jikanime.data.Anime
import com.android.mr.jikanime.data.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    private val repository: AnimeRepository
) : ViewModel() {

    private val _animeDetails = MutableLiveData<Anime?>()
    val animeDetails: LiveData<Anime?> = _animeDetails

    fun fetchAnimeDetails(animeId: Int) {
        viewModelScope.launch {
            val details = repository.getAnimeDetails(animeId)
            _animeDetails.postValue(details)
        }
    }
}
