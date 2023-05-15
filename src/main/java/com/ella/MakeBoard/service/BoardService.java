package com.ella.MakeBoard.service;

import com.ella.MakeBoard.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<Board> getBoardList();                     // 게시글 전체 불러오기
    Optional<Board> getBoardOne(Long seq);          // 게시글 하나 불러오기
    Board insertBoard(Board board);                 // 게시글 저장
    // 게시글 수정
    // 게시글 삭제
}
