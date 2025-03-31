package com.example.paging3example.presentation.mvi

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import com.example.paging3example.data.models.Character

data class CharacterViewState(
    val pagingDataFlow: Flow<PagingData<Character>>? = null
)
