package com.ella.MakeBoard.service;

import com.ella.MakeBoard.domain.Board;
import com.ella.MakeBoard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardRepository boardRepository;

    /**
     * 게시판 리스트
     * @return List<Board>
     */
    @Override
    public List<Board> getBoardList(){
        return boardRepository.findAll();
    }

    /**
     * 게시글 하나
     * @param boardSeq
     * @return Optional<Board>
     */
    @Override
    public Optional<Board> getBoardOne(Long boardSeq){
        return boardRepository.findById(boardSeq);
    }

    /**
     * 게시글 등록
     * @param board
     * @return Board
     */
    @Override
    public Board insertBoard(Board board){
        return boardRepository.save(board);
    }
}
