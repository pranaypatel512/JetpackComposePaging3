package com.example.paging3example.presentation.mvi

sealed class CharacterIntent {
    object LoadCharacters : CharacterIntent()
    object RefreshCharacters : CharacterIntent()
    object Retry : CharacterIntent()
}
