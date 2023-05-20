package com.ella.MakeBoard.controller;

import com.ella.MakeBoard.dto.BoardDto;
import com.ella.MakeBoard.dto.PagingDto;
import com.ella.MakeBoard.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public Map<String, Object> getBoardList(PagingDto pagingDto) {
        return boardService.getBoardList(pagingDto);
    }

    /**
     * 게시글 하나
     * @param boardSeq
     * @return ResponseEntity<Optional<Board>>
     */
    @GetMapping("/getBoardOne/{boardSeq}")
    public BoardDto getBoardOne(@PathVariable("boardSeq") long boardSeq) {
        return boardService.getBoardOne(boardSeq);
    }

    /**
     * 게시글 등록
     * @param boardDto
     * @return ResponseEntity<Board>
     */
    @PostMapping("/insertBoard")
    public Long insertBoard(@RequestBody BoardDto boardDto){
        return boardService.insertBoard(boardDto);
    }

    /**
     * 게시글 수정
     * @param boardDto
     * @return Long
     */
    @PatchMapping("/updateBoard")
    public Long updateBoard(@RequestBody BoardDto boardDto){
        return boardService.updateBoard(boardDto);
    }

    /**
     * 게시글 삭제
     * @param boardSeq
     * @return boolean
     */
    @DeleteMapping("/deleteBoard/{boardSeq}")
    public boolean deleteBoard(@PathVariable("boardSeq") long boardSeq) {
        return boardService.deleteBoard(boardSeq);
    }

}
