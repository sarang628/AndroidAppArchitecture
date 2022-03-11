package com.example.androidapparchitecture.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapparchitecture.data.Message
import com.example.androidapparchitecture.data.NewsUiState
import com.example.androidapparchitecture.repository.NewsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

class NewsViewModel(

) : ViewModel() {

    private val repository: NewsRepository = NewsRepository()

    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    private var fetchJob: Job? = null

    fun fetchArticles(category: String) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                _uiState.update {
                    it.copy(isFetchingArticles = true)
                }

                val newsItems = repository.newsItemsForCategory(category)
                Log.d("__sr", "" + newsItems.size)
                _uiState.update {
                    Log.d("__sr", "update")
                    it.copy(newsItems = newsItems)
                    it.copy(isFetchingArticles = false)
                }
            } catch (ioe: IOException) {
                // Handle the error and notify the UI when appropriate.
                Log.d("__sr", ioe.toString())
                _uiState.update {
                    val messages = getMessagesFromThrowable(ioe)
                    it.copy(userMessages = messages)
                }
            }
        }
    }

    private fun getMessagesFromThrowable(ioe: IOException): List<Message> {
        return listOf()
    }

}