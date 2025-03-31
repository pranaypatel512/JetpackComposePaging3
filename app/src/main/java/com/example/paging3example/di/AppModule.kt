package com.example.paging3example.di

import com.example.paging3example.data.network.RickAndMortyApi
import com.example.paging3example.data.repository.CharacterRepository
import com.example.paging3example.ui.screens.dashboard.CharacterViewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {

    single<RickAndMortyApi> {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApi::class.java)
    }

    single { CharacterRepository(get()) }

    viewModel { CharacterViewModel(get()) }
}
