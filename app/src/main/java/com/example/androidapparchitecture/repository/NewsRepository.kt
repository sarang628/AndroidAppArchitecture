package com.example.androidapparchitecture.repository

import com.example.androidapparchitecture.data.NewsItemUiState
import kotlinx.coroutines.delay

class NewsRepository {
    suspend fun newsItemsForCategory(category: String): List<NewsItemUiState> {
        return ArrayList<NewsItemUiState>().apply {
            delay(2000)
            add(
                NewsItemUiState(
                    title = "" + size,
                    body = "c"
                )
            )
        }
    }
}