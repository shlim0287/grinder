package com.grinder.common.security.oauth.model.implement;

import com.grinder.common.security.oauth.model.response.GoogleResponse;
import com.grinder.common.security.oauth.model.response.KakaoResponse;
import com.grinder.common.security.oauth.model.response.NaverResponse;
import com.grinder.common.security.oauth.model.response.OAuth2Response;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuth2ResponseConverter {
    public OAuth2Response convert(OAuth2UserRequest request, OAuth2User oAuth2User) {
        String registrationId = request.getClientRegistration().getRegistrationId();

        switch (registrationId) {
            case "naver":
                return new NaverResponse(oAuth2User.getAttributes());
            case "google":
                return new GoogleResponse(oAuth2User.getAttributes());
            case "kakao":
                return new KakaoResponse(oAuth2User.getAttributes());
            default:
                throw new OAuth2AuthenticationException("Unsupported Provider");
        }
    }
}