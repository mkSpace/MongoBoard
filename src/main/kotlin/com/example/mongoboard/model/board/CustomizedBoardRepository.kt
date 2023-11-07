package com.example.mongoboard.model.board

import org.springframework.data.domain.Page

interface CustomizedBoardRepository {
    fun findAllWithPaging(page: Int, limit: Int): Page<Board>
}