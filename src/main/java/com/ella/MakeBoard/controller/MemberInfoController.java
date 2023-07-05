package com.ella.MakeBoard.controller;

import com.ella.MakeBoard.dto.MemberInfoDto;
import com.ella.MakeBoard.service.MemberInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/member")
public class MemberInfoController {

    @Autowired
    MemberInfoServiceImpl memberInfoService;

    /**
     * 회원가입
     * @param memberInfoDto
     * @return
     */
    @PostMapping("/insertMember")
    public Boolean insertMember(@RequestBody MemberInfoDto memberInfoDto) {
        Long result = memberInfoService.insertMember(memberInfoDto);
        return result != null;
    }
}
