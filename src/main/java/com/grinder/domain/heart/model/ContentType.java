package com.grinder.domain.heart.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ContentType {
    MEMBER("회원"),
    FEED("피드"),
    CAFE("카페"),
    MENU("메뉴"),
    COMMENT("댓글");

    private final String value;
}