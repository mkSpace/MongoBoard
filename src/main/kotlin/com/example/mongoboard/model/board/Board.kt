package com.example.mongoboard.model.board

import com.example.mongoboard.model.BaseEntity
import com.example.mongoboard.model.board.Board.Companion.COLLECTION_NAME
import com.example.mongoboard.model.user.User
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = COLLECTION_NAME)
class Board(
    var title: String,
    var content: String,
    var likedUsers: List<User> = emptyList()
) : BaseEntity() {

    companion object {
        const val COLLECTION_NAME = "boards"
    }

    fun update(title: String? = null, content: String? = null): Board {
        this.title = title ?: this.title
        this.content = content ?: this.content
        return this
    }

    fun like(user: User){
        this.likedUsers = (this.likedUsers + listOf(user)).distinct()
    }

    fun dislike(user: User){
        this.likedUsers = this.likedUsers - user
    }

}