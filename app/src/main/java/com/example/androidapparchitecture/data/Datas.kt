package com.example.androidapparchitecture.data

data class NewsUiState(
    val isFetchingArticles: Boolean = false,
    val isSignedIn: Boolean = false,
    val isPremium: Boolean = false,
    val newsItems: List<NewsItemUiState> = listOf(),
    val userMessages: List<Message> = listOf()
)

val NewsUiState.canBookmarkNews: Boolean get() = isSignedIn && isPremium

data class NewsItemUiState(
    val userMessages: List<Message> = listOf(),
    val title: String,
    val body: String,
    val bookmarked: Boolean = false
)


data class Message(val id: Long, val message: String)