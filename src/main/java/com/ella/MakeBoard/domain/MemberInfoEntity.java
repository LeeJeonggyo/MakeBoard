package com.ella.MakeBoard.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="member_info")
public class MemberInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberSeq;              // 게시판 PK

    @Column(name = "id")
    private String id;               // 제목

    @Column(name = "pw")
    private String pw;             // 내용

    @Column(name = "name")
    private String name;             // 이름

    @Column(name = "mod_date")
    private LocalDateTime modDate;      // 수정일

    @Column(name = "inp_date")
    private LocalDateTime inpDate;      // 등록일

    @Builder
    public MemberInfoEntity(String id, String pw, String name){
        this.id = id;
        this.pw = pw;
        this.name = name;
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

}
