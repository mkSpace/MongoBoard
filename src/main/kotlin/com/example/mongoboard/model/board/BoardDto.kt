package com.example.mongoboard.model.board

data class BoardDto(
    val title: String,
    val content: String,
    val likeCount: Int,
    val id: String
)

fun Board.toDto(): BoardDto = BoardDto(title = title, content = content, likeCount = likedUsers.size, id = id!!)