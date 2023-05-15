package com.ella.MakeBoard.controller;

import com.ella.MakeBoard.domain.Board;
import com.ella.MakeBoard.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boardList")
public class BoardController {
    @Autowired
    BoardServiceImpl boardService;

    /**
     * 게시글 전체 리스트
     * @return ResponseEntity<List<Board>>
     */
    @GetMapping("/getBoardList")
    public ResponseEntity<List<Board>> getBoardList() {
        return ResponseEntity.ok(boardService.getBoardList());
    }

    /**
     * 게시글 하나
     * @param boardSeq
     * @return ResponseEntity<Optional<Board>>
     */
    @GetMapping("/getBoardOne/{boardSeq}")
    public ResponseEntity<Optional<Board>> getBoardOne(@PathVariable("boardSeq") long boardSeq) {
        return ResponseEntity.ok(boardService.getBoardOne(boardSeq));
    }

    /**
     * 게시글 등록
     * @param board
     * @return ResponseEntity<Board>
     */
    @PostMapping("/insertBoard")
    public ResponseEntity<Board> insertBoard(@RequestBody Board board){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(boardService.insertBoard(board));
    }
}
