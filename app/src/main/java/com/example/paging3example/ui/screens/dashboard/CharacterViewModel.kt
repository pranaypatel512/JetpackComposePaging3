package com.example.paging3example.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.paging3example.data.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {

    private val _state = MutableStateFlow(CharacterViewState())
    val state: StateFlow<CharacterViewState> = _state.asStateFlow()

    init {
        processIntent(CharacterIntent.LoadCharacters)
    }

    fun processIntent(intent: CharacterIntent) {
        viewModelScope.launch {
            when (intent) {
                is CharacterIntent.LoadCharacters -> {
                    _state.value = CharacterViewState(
                        pagingDataFlow = repository.getCharacters().cachedIn(viewModelScope)
                    )
                }
                is CharacterIntent.RefreshCharacters -> {
                    _state.value = CharacterViewState(
                        pagingDataFlow = repository.getCharacters().cachedIn(viewModelScope)
                    )
                }
                is CharacterIntent.Retry -> {
                    // Retry logic
                }
            }
        }
    }
}

