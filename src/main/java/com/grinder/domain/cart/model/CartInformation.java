package com.grinder.domain.cart.model;

import com.grinder.domain.cafe.model.Cafe;
import com.grinder.domain.menu.model.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartInformation {
    private Cafe cafe;
    private List<Menu> menuList;
}
