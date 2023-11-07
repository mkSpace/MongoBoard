package com.example.mongoboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing

@SpringBootApplication
@EnableMongoAuditing
class MongoBoardApplication

fun main(args: Array<String>) {
    runApplication<MongoBoardApplication>(*args)
}
