package com.grinder.domain.member.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberBasicInfo {
    private Long id;

    private String email;

    private String phoneNumber;

    private TierType tier;
}
