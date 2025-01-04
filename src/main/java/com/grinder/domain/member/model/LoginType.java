package com.grinder.domain.member.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginType {
    SOCIAL("social"),
    COMMON("common");

    private final String value;
}
