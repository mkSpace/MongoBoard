package com.example.mongoboard.model.user

import com.example.mongoboard.model.BaseEntity
import com.example.mongoboard.model.user.User.Companion.COLLECTION_NAME
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = COLLECTION_NAME)
class User(
    val userName: String,
    val password: String
): BaseEntity() {

    companion object {
        const val COLLECTION_NAME = "users"
    }

}