package com.ella.MakeBoard.domain;

import com.ella.MakeBoard.dto.BoardDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSeq;              // 게시판 PK

    @Column(name = "title")
    private String title;               // 제목

    @Column(name = "content")
    private String content;             // 내용

    @Column(name = "mod_date")
    private LocalDateTime modDate;      // 수정일

    @Column(name = "inp_date")
    private LocalDateTime inpDate;      // 등록일

    @Builder
    public BoardEntity(String title, String content){
        this.title = title;
        this.content = content;
    }


    /* =======================================================
     * 입력, 수정 날짜 셋팅
     * ======================================================= */
    @PrePersist
    public void prePersist(){
        this.inpDate = LocalDateTime.now();
    }

    @PreUpdate
    public void PreUpdate(){
        this.modDate = LocalDateTime.now();
    }


    /* =======================================================
     * 게시판 데이터 수정
     * ======================================================= */
    /**
     * 제목(title) / 내용(content) 수정
     * @param dto
     */
    public void update(BoardDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }
}

