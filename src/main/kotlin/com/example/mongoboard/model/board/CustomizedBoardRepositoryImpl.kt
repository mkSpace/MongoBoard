package com.example.mongoboard.model.board

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.support.PageableExecutionUtils

class CustomizedBoardRepositoryImpl(private val mongoTemplate: MongoTemplate) : CustomizedBoardRepository {
    override fun findAllWithPaging(page: Int, limit: Int): Page<Board> {
        val pageable = PageRequest.of(page, limit)
        val query = Query()
            .with(pageable)
            .skip((pageable.pageSize * pageable.pageNumber).toLong())
            .limit(pageable.pageSize)

        val boards = mongoTemplate.find(query, Board::class.java, Board.COLLECTION_NAME)
        return PageableExecutionUtils.getPage(boards, pageable) {
            mongoTemplate.count(query.skip(-1).limit(-1), Board::class.java)
        }
    }
}