package com.example.paging3example.data.models

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)

data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
