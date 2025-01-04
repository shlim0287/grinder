package com.grinder.domain.member.implement;

import com.grinder.common.exception.MemberException;
import com.grinder.domain.member.entity.MemberEntity;
import com.grinder.domain.member.model.LoginType;
import com.grinder.domain.member.model.Member;
import com.grinder.domain.member.model.MemberBasicInfo;
import com.grinder.domain.member.model.TierType;
import com.grinder.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberManager {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public MemberBasicInfo read(Long id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new MemberException("해당 회원이 존재하지 않습니다.")
        ).toBasicInfo();
    }
    public MemberBasicInfo readEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(
                () -> new MemberException("해당 이메일로 가입된 회원이 없습니다.")
        ).toBasicInfo();
    }

    public Member save(String email, String password) {
        MemberEntity memberEntity = MemberEntity.commonBuilder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .loginType(LoginType.COMMON)
                .tier(TierType.SILVER)
                .isDeleted(false)
                .build();

        return memberRepository.save(memberEntity).toMember();
    }

    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .map(MemberEntity::toMember);
    }

    public void validateDuplicateEmail(String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new MemberException("이미 사용 중인 이메일입니다");
        }
    }
}
