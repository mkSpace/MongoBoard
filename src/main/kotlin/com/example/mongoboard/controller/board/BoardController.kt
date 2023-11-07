package com.example.mongoboard.controller.board

import com.example.mongoboard.Constants.API_ENDPOINT
import com.example.mongoboard.model.board.BoardDto
import com.example.mongoboard.model.board.BoardService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("$API_ENDPOINT/board")
class BoardController(private val boardService: BoardService) {

    @PostMapping
    fun createBoard(@RequestBody requestBody: BoardCreateRequest): BoardDto {
        return boardService.createBoard(requestBody.title, requestBody.content)
    }

    @GetMapping
    fun getAllByPaging(@RequestParam("page") page: Int? = 0, @RequestParam("size") size: Int? = null): Page<BoardDto> {
        return boardService.getBoards(page, size)
    }

    @GetMapping("/{boardId}")
    fun getDetail(@PathVariable("boardId") boardId: String): BoardDto {
        return boardService.getBoardDetail(boardId)
    }

    @PutMapping("/{boardId}")
    fun updateBoard(@PathVariable("boardId") boardId: String, @RequestBody requestBody: BoardUpdateRequest): BoardDto {
        return boardService.updateBoard(boardId, requestBody.title, requestBody.content)
    }

    @DeleteMapping("/{boardId}")
    fun deleteBoard(@PathVariable("boardId") boardId: String) {
        boardService.deleteBoard(boardId)
    }
}