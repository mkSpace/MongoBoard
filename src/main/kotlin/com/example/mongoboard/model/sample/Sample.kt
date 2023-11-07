package com.example.mongoboard.model.sample

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "samples")
class Sample(
    val firstName: String,
    val lastName: String,
    @Id var id: String? = null
)