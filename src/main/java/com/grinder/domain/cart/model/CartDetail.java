package com.grinder.domain.cart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDetail {
    private Long id;

    private Long cartId;

    private Long menuId;

    private int quantity;
}
