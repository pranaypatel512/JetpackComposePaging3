package com.example.paging3example.ui.screens.dashboard

import androidx.paging.PagingData
import com.example.paging3example.data.models.Character
import kotlinx.coroutines.flow.Flow

sealed class CharacterIntent {
    object LoadCharacters : CharacterIntent()
    object RefreshCharacters : CharacterIntent()
    object Retry : CharacterIntent()
}

data class CharacterViewState(
    val pagingDataFlow: Flow<PagingData<Character>>? = null
)
