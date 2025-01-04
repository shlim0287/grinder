package com.grinder.domain.cart.implement;

import com.grinder.domain.cart.entity.CartDetailEntity;
import com.grinder.domain.cart.entity.CartEntity;
import com.grinder.domain.cart.model.Cart;
import com.grinder.domain.cart.model.CartDetail;
import com.grinder.domain.cart.reopository.CartDetailRepository;
import com.grinder.domain.cart.reopository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartReader {
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;

    public List<CartDetail> readDetails(Long cartId) {
        return cartDetailRepository.findAllByCartId(cartId).stream().map(CartDetailEntity::toCartDetail).collect(Collectors.toList());
    }

    public Cart create(Long memberId, Long cafeId) {
        return cartRepository.save(CartEntity.builder()
                .memberId(memberId)
                .cafeId(cafeId)
                .build()
        ).toCart();
    }

    public CartDetail createDetail(Long cartDetailId, Long menuId, int quantity) {
        return cartDetailRepository.save(CartDetailEntity.builder()
                .cartId(cartDetailId)
                .menuId(menuId)
                .quantity(quantity)
                .build()
        ).toCartDetail();
    }

    public boolean modifyCart(Long cartId, Long cafeId) {
        try {
            cartRepository.updateCafeId(cartId, cafeId);
        } catch (Exception e) {
            throw new IllegalArgumentException("해당 장바구니가 존재하지 않습니다.");
        }
        return true;
    }

    public boolean hasUnorderedCart(Long memberId, Long cafeId) {
        return cartRepository.existsByMemberIdAndCafeIdAndIsOrderedIsFalse(memberId, cafeId);
    }

    public Cart findCart(Long memberId, Long cafeId) {
        return cartRepository.findByMemberIdAndCafeIdAndIsOrderedIsFalse(memberId, cafeId).orElseThrow(
                () -> new IllegalArgumentException("해당 카페의 장바구니가 존재하지 않습니다.")
        ).toCart();
    }

    public Cart readByMemberId(Long memberId) {
        return cartRepository.findByMemberIdAndIsOrderedIsFalse(memberId).orElseThrow(
                () -> new IllegalArgumentException("해당 회원의 장바구니가 존재하지 않습니다.")
        ).toCart();
    }

    public Cart read(Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(
                () -> new IllegalArgumentException("해당 장바구니가 존재하지 않습니다.")
        ).toCart();
    }

}
