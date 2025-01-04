package com.grinder.domain.cart.implement;

import com.grinder.domain.cafe.implement.CafeReader;
import com.grinder.domain.cafe.model.Cafe;
import com.grinder.domain.cart.model.Cart;
import com.grinder.domain.cart.model.CartDetail;
import com.grinder.domain.cart.model.CartInformation;
import com.grinder.domain.menu.implement.MenuReader;
import com.grinder.domain.menu.model.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartManager {
    private final MenuReader menuReader;
    private final CartReader cartReader;
    private final CafeReader cafeReader;

    public CartInformation getMyCart(Long memberId) {
        Cart cart = cartReader.readByMemberId(memberId);
        Cafe cafe = cafeReader.read(cart.getCafeId());

        List<CartDetail> cartDetails = cartReader.readDetails(cart.getId());

        List<Menu> menus = menuReader.readAll(cartDetails.stream()
                .map(CartDetail::getMenuId)
                .collect(Collectors.toList()));

        return CartInformation.builder()
                .cafe(cafe)
                .menuList(menus)
                .build();
    }

    public void createCart(Long memberId, Long cafeId) {
        if (cartReader.hasUnorderedCart(memberId, cafeId)) {
            throw new IllegalArgumentException("다른 카페의 장바구니가 이미 존재합니다.");
        }
        cartReader.create(memberId, cafeId);
    }

    public boolean overwriteCart(Long cartId, Long cafeId) {
        return cartReader.modifyCart(cartId, cafeId);
    }

    public CartDetail addMenu(Long cartDetailId, Long menuId, int quantity) {
        Menu menu = menuReader.read(menuId);

        if (menu.getStock() <= 0 || menu.getStock() - quantity < 0) {
            throw new IllegalArgumentException("해당 메뉴의 재고가 부족합니다.");
        }

        return cartReader.createDetail(cartDetailId, menuId, quantity);
    }
}
