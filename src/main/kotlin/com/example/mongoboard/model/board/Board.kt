package com.example.mongoboard.model.board

import com.example.mongoboard.model.BaseEntity
import com.example.mongoboard.model.board.Board.Companion.COLLECTION_NAME
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = COLLECTION_NAME)
class Board(
    var title: String,
    var content: String,
) : BaseEntity() {

    companion object {
        const val COLLECTION_NAME = "boards"
    }

    fun update(title: String? = null, content: String? = null): Board {
        this.title = title ?: this.title
        this.content = content ?: this.content
        return this
    }
}