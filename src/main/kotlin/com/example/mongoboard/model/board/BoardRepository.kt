package com.example.mongoboard.model.board

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : MongoRepository<Board, String>, CustomizedBoardRepository