package com.ella.MakeBoard.service;

import com.ella.MakeBoard.dto.MemberInfoDto;

public interface MemberInfoService {
    /**
     * 회원가입
     * @param memberInfoDto
     * @return
     */
    Long insertMember(MemberInfoDto memberInfoDto);
}
