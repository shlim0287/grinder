package com.grinder.domain.cart.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Cart {
    private Long id;

    private Long memberId;

    private Long cafeId;

    public static class WithDetail {
        private Long cafeId;

        private Long menuId;

        private int quantity;
    }
}
