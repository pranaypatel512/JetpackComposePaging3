package com.example.paging3example.data.network

import com.example.paging3example.data.models.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("api/character")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResponse
}
