package com.ella.MakeBoard.dto;

import com.ella.MakeBoard.domain.BoardEntity;
import com.ella.MakeBoard.domain.MemberInfoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MemberInfoDto {
    private Long memberSeq;              // 게시판 PK
    private String id;               // 제목
    private String pw;             // 내용
    private String name;             // 내용
    private LocalDateTime modDate;      // 수정일
    private LocalDateTime inpDate;      // 등록일

    /* =======================================================
     * entity -> dto 변환을 위한 생성자
     * ======================================================= */
    public MemberInfoDto(MemberInfoEntity member){
        this.memberSeq = member.getMemberSeq();
        this.id = member.getId();
        this.pw = member.getPw();
        this.name = member.getName();
        this.modDate = member.getModDate();
        this.inpDate = member.getInpDate();
    }

    /* =======================================================
     * dto -> entity 변환
     * ======================================================= */
    public MemberInfoEntity toEntity(){
        return MemberInfoEntity.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .build();
    }
}
