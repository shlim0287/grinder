package com.grinder.common.security.oauth.model.response;

import java.util.Map;
import java.util.Optional;

public class KakaoResponse implements OAuth2Response{

    private final Map<String,Object> attribute;

    public KakaoResponse(Map<String,Object> attribute){
        this.attribute = attribute;
    }
    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getProviderId() {
        return attribute.get("id").toString();
    }

    @Override
    public String getEmail() {
        return Optional.ofNullable((Map<String,Object>)attribute.get("kakao_account"))
                .map(kakaoAccount-> (String) kakaoAccount.get("email"))
                .orElse(null);
    }

    @Override
    public String getName() {
        return Optional.ofNullable((Map<String,Object>)attribute.get("properties"))
                .map(kakaoAccount-> (String) kakaoAccount.get("nickname"))
                .orElse(null);
    }
}
