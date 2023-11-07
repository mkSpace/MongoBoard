package com.example.mongoboard.model.sample

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SampleRepository : MongoRepository<Sample, String> {
    fun findByFirstName(firstName: String?): Sample?
    fun findByLastName(lastName: String?): List<Sample>
}