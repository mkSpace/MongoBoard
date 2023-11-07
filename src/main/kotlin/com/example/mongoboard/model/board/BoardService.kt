package com.example.mongoboard.model.board

import org.springframework.data.domain.Page
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class BoardService(private val boardRepository: BoardRepository) {

    companion object {
        private const val DEFAULT_PAGE_SIZE = 20
    }

    @Transactional
    fun createBoard(title: String, content: String): BoardDto {
        val board = Board(title = title, content = content)
        boardRepository.save(board)
        return board.toDto()
    }

    fun getBoardDetail(id: String): BoardDto {
        return boardRepository.findByIdOrNull(id)?.toDto() ?: throw IllegalStateException()
    }

    fun getBoards(page: Int?, limit: Int?): Page<BoardDto> {
        return boardRepository.findAllWithPaging(page ?: 0, limit ?: DEFAULT_PAGE_SIZE).map { it.toDto() }
    }

    @Transactional
    fun updateBoard(id: String, title: String? = null, content: String? = null): BoardDto {
        val board = boardRepository.findByIdOrNull(id) ?: throw IllegalStateException()
        board.update(title, content)
        boardRepository.save(board)
        return board.toDto()
    }

    @Transactional
    fun deleteBoard(id: String) {
        val board = boardRepository.findByIdOrNull(id) ?: throw IllegalStateException()
        boardRepository.delete(board)
    }
}