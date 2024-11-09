package com.grinder.domain.menu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Long id;

    private String description;

    private String price;

    private int stock;

    private boolean seasonYn;

    private int sequence;

    private Long imageId;

    private Long cafeId;
}
