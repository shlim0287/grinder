package com.grinder.common.security.oauth.model.implement;

import com.grinder.common.security.oauth.model.response.OAuth2Response;
import com.grinder.domain.member.entity.MemberEntity;
import com.grinder.domain.member.model.LoginType;
import com.grinder.domain.member.model.Member;
import com.grinder.domain.member.model.TierType;
import com.grinder.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class Oauth2MemberManager {
    private final MemberRepository memberRepository;

    public Member findOrCreate(OAuth2Response oAuth2Response) {
        return memberRepository.findByEmail(oAuth2Response.getEmail())
                .map(MemberEntity::toMember)
                .orElseGet(() -> createNewMember(oAuth2Response));
    }

    private Member createNewMember(OAuth2Response oAuth2Response) {
        MemberEntity newMember = MemberEntity.socialBuilder()
                .email(oAuth2Response.getEmail())
                .loginType(LoginType.SOCIAL)
                .tier(TierType.SILVER)
                .isDeleted(false)
                .build();

        return memberRepository.save(newMember).toMember();
    }
}