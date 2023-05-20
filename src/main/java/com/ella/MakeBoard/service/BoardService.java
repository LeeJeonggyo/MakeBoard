package com.ella.MakeBoard.service;

import com.ella.MakeBoard.dto.BoardDto;
import com.ella.MakeBoard.dto.PagingDto;

import java.util.Map;

public interface BoardService {
    Map<String, Object> getBoardList(PagingDto pagingDto);     // 게시글 전체 불러오기
    BoardDto getBoardOne(Long seq);         // 게시글 하나 불러오기
    Long insertBoard(BoardDto boardDto);    // 게시글 저장
    Long updateBoard(BoardDto boardDto);    // 게시글 수정
    boolean deleteBoard(Long boardSeq);     // 게시글 삭제
}
