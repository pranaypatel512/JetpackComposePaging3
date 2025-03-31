package com.example.paging3example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3example.data.network.RickAndMortyApi
import com.example.paging3example.data.models.Character

class CharacterPagingSource(private val api: RickAndMortyApi) : PagingSource<Int, Character>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val currentPage = params.key ?: 1
        return try {
            val response = api.getCharacters(currentPage)
            val nextPage = if (response.info.next != null) currentPage + 1 else null
            LoadResult.Page(
                data = response.results,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }
}
