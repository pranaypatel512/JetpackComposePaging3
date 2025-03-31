package com.example.paging3example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
import com.example.paging3example.data.network.RickAndMortyApi
import com.example.paging3example.data.paging.CharacterPagingSource
import com.example.paging3example.data.models.Character

class CharacterRepository(private val api: RickAndMortyApi) {
    fun getCharacters(): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = 20, enablePlaceholders = false),
        pagingSourceFactory = { CharacterPagingSource(api) }
    ).flow
}
