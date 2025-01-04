package com.grinder.common.security.common.service;

import com.grinder.common.security.common.model.MemberUserDetails;
import com.grinder.domain.member.model.LoginType;
import com.grinder.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findByEmailAndLoginType(email, LoginType.COMMON)
                .filter(member -> !member.isDeleted())
                .map(MemberUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("회원 정보가 존재하지 않습니다: " + email));
    }
}