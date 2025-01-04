package com.grinder.domain.tabling.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusType {
    WAITING("대기중"),
    CANCEL("취소");

    private final String value;
}
