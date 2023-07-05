package com.ella.MakeBoard.dto;

import com.ella.MakeBoard.domain.BoardEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
     * entity -> dto 변환을 위한 생성자
     * ======================================================= */
    public BoardDto(BoardEntity board){
        this.boardSeq = board.getBoardSeq();
        this.content = board.getContent();
        this.title = board.getTitle();
        this.modDate = board.getModDate();
        this.inpDate = board.getInpDate();
    }

    /* =======================================================
     * dto -> entity 변환
     * ======================================================= */
    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .title(title)
                .content(content)
                .build();
    }

}