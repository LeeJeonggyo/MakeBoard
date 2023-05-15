package com.ella.MakeBoard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {
    private Long boardSeq;
    private String title;
    private String content;
    private LocalDateTime modDate;
    private LocalDateTime inpDate;

//    public BoardDto(BoardEntity board){
//        this.seq = board.getSeq();
//        this.title = board.getTitle();
//        this.content = board.getContent();
//        this.modDate = board.getModDate();
//        this.inpDate = board.getInpDate();
//    }

//    public BoardEntity toEntity() {
//        return BoardEntity.builder()
//                .title(title)
//                .content(content)
//                .build();
//    }

}

