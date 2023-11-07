package com.example.mongoboard.model.sample

import com.example.mongoboard.model.BaseEntity
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "samples")
class Sample(
    val firstName: String,
    val lastName: String
) : BaseEntity()