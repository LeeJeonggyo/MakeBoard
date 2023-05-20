package com.ella.MakeBoard.dto;

import com.ella.MakeBoard.domain.BoardEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {
    private Long boardSeq;              // 게시판 PK
    private String title;               // 제목
    private String content;             // 내용
    private LocalDateTime modDate;      // 수정일
    private LocalDateTime inpDate;      // 등록일

    /* =======================================================
     * dto -> entity 변환
     * ======================================================= */
    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .title(title)
                .content(content)
                .build();
    }

    /* =======================================================
     * entity -> dto 변환
     * ======================================================= */
    public static BoardDto toDto(BoardEntity board){
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardSeq(board.getBoardSeq());
        boardDto.setContent(board.getContent());
        boardDto.setTitle(board.getTitle());
        boardDto.setModDate(board.getModDate());
        boardDto.setInpDate(board.getInpDate());
        return boardDto;
    }

}

