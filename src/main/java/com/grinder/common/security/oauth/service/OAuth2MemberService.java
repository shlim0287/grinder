package com.grinder.common.security.oauth.service;

import com.grinder.common.security.oauth.model.OAuth2MemberDetails;
import com.grinder.common.security.oauth.model.implement.Oauth2MemberManager;
import com.grinder.common.security.oauth.model.implement.OAuth2ResponseConverter;
import com.grinder.common.security.oauth.model.response.OAuth2Response;
import com.grinder.domain.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2MemberService extends DefaultOAuth2UserService {
    private final OAuth2ResponseConverter oAuth2ResponseConverter;
    private final Oauth2MemberManager oauth2MemberManager;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(request);
        OAuth2Response oAuth2Response = oAuth2ResponseConverter.convert(request, oAuth2User);
        Member member = oauth2MemberManager.findOrCreate(oAuth2Response);
        return new OAuth2MemberDetails(oAuth2Response, member.getTier());
    }
}
