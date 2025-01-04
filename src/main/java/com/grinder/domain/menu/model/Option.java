package com.grinder.domain.menu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Option {
    private Long id;

    private String name;

    private Long price;

    private int stock;

    private boolean lockYn;

    private Long menuId;
}
