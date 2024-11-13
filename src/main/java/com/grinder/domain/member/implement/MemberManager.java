package com.grinder.domain.member.implement;

import com.grinder.domain.member.entity.MemberEntity;
import com.grinder.domain.member.model.LoginType;
import com.grinder.domain.member.model.Member;
import com.grinder.domain.member.model.MemberBasicInfo;
import com.grinder.domain.member.model.MemberRegister;
import com.grinder.domain.member.model.TierType;
import com.grinder.domain.member.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberManager {
    private final MemberRepository memberRepository;

    public MemberBasicInfo read(Long id) {
        return memberRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("해당 회원이 존재하지 않습니다.") ).toBasicInfo();
    }
    public MemberBasicInfo readEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow( () -> new IllegalArgumentException("해당 이메일로 가입된 회원이 없습니다.") ).toBasicInfo();
    }

    public Member save(MemberRegister request, String encodedPassword) {
        MemberEntity memberEntity = MemberEntity.commonBuilder()
                .email(request.getEmail())
                .password(encodedPassword)
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
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다");
        }
    }
}