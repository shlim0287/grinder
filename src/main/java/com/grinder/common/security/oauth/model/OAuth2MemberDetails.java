package com.grinder.common.security.oauth.model;

import com.grinder.common.security.oauth.model.response.OAuth2Response;
import com.grinder.domain.member.model.TierType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
@RequiredArgsConstructor
public class OAuth2MemberDetails implements OAuth2User {

    private final OAuth2Response oAuth2Response;
    private final TierType type;



    @Override
    public Map<String, Object> getAttributes() {

        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new SimpleGrantedAuthority(type.getValue()));
        return collection;
    }

    @Override
    public String getName() {
        return oAuth2Response.getName();
    }
}
