package com.example.mongoboard.controller.board

data class BoardCreateRequest(val title: String, val content: String)

data class BoardUpdateRequest(val title: String? = null, val content: String? = null)