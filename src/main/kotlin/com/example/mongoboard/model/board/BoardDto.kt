package com.example.mongoboard.model.board

data class BoardDto(
    val title: String,
    val content: String,
    val id: String
)

fun Board.toDto(): BoardDto = BoardDto(title = title, content = content, id = id!!)