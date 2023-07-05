package com.ella.MakeBoard.service;

import com.ella.MakeBoard.domain.MemberInfoEntity;
import com.ella.MakeBoard.dto.BoardDto;
import com.ella.MakeBoard.dto.MemberInfoDto;
import com.ella.MakeBoard.repository.MemberInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberInfoServiceImpl implements MemberInfoService{
    @Autowired
    private MemberInfoRepository memberInfoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     * @param memberInfoDto
     * @return
     */
    @Override
    public Long insertMember(MemberInfoDto memberInfoDto){
        // 아이디가 존재하지 않을 경우, 회원 등록
        if (checkAvailId(memberInfoDto.getId())){
            memberInfoDto.setPw(passwordEncoder.encode(memberInfoDto.getPw()));
            return memberInfoRepository.save(memberInfoDto.toEntity()).getMemberSeq();
        } else {
            return null;
        }
    }

    /**
     * 아이디로 회원 조회
     * @param id
     * @return
     */
    public MemberInfoDto getMemberOneById(String id){
        Optional<MemberInfoEntity> memberInfoEntity = memberInfoRepository.findById(id);
        return memberInfoEntity.isPresent() ? new MemberInfoDto(memberInfoEntity.get()) : null;
    }

    /**
     * 사용가능한 아이디인지 확인
     * @param id
     * @return
     */
    public Boolean checkAvailId(String id){
        return getMemberOneById(id) != null;
    }
}
