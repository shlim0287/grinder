package com.grinder.domain.cafe.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Cafe {
    private Long id;

    private String name;

    private String address;

    private String description;

    private String tel;
}
