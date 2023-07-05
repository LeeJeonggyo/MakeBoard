package com.ella.MakeBoard.config;

import com.ella.MakeBoard.dto.MemberInfoDto;
import com.ella.MakeBoard.service.MemberInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberInfoServiceImpl memberInfoService;

    @Override
    public UserDetails loadUserByUsername(String insertedUserId) {
        MemberInfoDto member = memberInfoService.getMemberOneById(insertedUserId);

        if (member == null){
            throw new UsernameNotFoundException("없는 회원입니다.");
        } else {
            return User.builder()
                    .username(member.getId())
                    .password(member.getPw())
                    .roles("")                  // roles가 없을 경우, 오류 발생.
                    .build();
        }
    }
}
