package com.ella.MakeBoard.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSeq;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "mod_date")
    private LocalDateTime modDate;

    @Column(name = "inp_date")
    private LocalDateTime inpDate;

    /* =======================================================
     * 생성자
     * ======================================================= */
    public Board(){}

    public Board(String title, String content){
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
     * getter setter
     * ======================================================= */
    public Long getBoardSeq() {
        return boardSeq;
    }

    public void setBoardSeq(Long boardSeq) {
        this.boardSeq = boardSeq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getModDate() {
        return modDate;
    }

    public void setModDate(LocalDateTime modDate) {
        this.modDate = modDate;
    }

    public LocalDateTime getInpDate() {
        return inpDate;
    }

    public void setInpDate(LocalDateTime inpDate) {
        this.inpDate = inpDate;
    }
}

