package com.ella.MakeBoard.service;

import com.ella.MakeBoard.domain.BoardEntity;
import com.ella.MakeBoard.dto.BoardDto;
import com.ella.MakeBoard.dto.PagingDto;
import com.ella.MakeBoard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardRepository boardRepository;

    /**
     * 게시판 리스트
     * @return List<Board>
     */
    @Override
    public Map<String, Object> getBoardList(PagingDto pagingDto){
        // 리스트 조회
        PageRequest pageRequest = PageRequest.of(pagingDto.getPageNumber(), pagingDto.getSize(), Sort.by(Sort.Order.desc("boardSeq")));
        Page<BoardEntity> boardEntity = boardRepository.findAll(pageRequest);

        // 리스트 dto 전환
        List<BoardDto> collect = boardEntity.getContent().stream()
                .map(BoardDto::toDto)
                .collect(Collectors.toList());

        // 데이터 담기
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("list", collect);                             // 전체 리스트
        resultMap.put("paging", pagingDto.pagingDto(boardEntity));  // 페이징

        return resultMap;
    }

    /**
     * 게시글 하나
     * @param boardSeq
     * @return Optional<Board>
     */
    @Override
    public BoardDto getBoardOne(Long boardSeq){
        Optional<BoardEntity> boardEntity = boardRepository.findById(boardSeq);
        return boardEntity.isPresent() ? BoardDto.toDto(boardEntity.get()) : null;
    }

    /**
     * 게시글 등록
     * @param boardDto
     * @return Board
     */
    @Override
    public Long insertBoard(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getBoardSeq();
    }

    /**
     * 게시글 수정
     * @param boardDto
     * @return Long
     */
    @Override
    @Transactional
    public Long updateBoard(BoardDto boardDto){
        Optional<BoardEntity> boardEntity = boardRepository.findById(boardDto.getBoardSeq());
        if(boardEntity.isPresent()){
            boardEntity.get().update(boardDto);
            return boardDto.getBoardSeq();
        }
        return null;
    }

    /**
     * 게시글 삭제
     * @param boardSeq
     * @return boolean
     */
    @Override
    public boolean deleteBoard(Long boardSeq){
        Optional<BoardEntity> boardEntity = boardRepository.findById(boardSeq);
        if(boardEntity.isPresent()){
            boardRepository.delete(boardEntity.get());
            return true;
        }
        return false;
    }
}
