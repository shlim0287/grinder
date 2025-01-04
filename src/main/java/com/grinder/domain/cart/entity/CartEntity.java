package com.grinder.domain.cart.entity;


import com.grinder.common.annotation.Name;
import com.grinder.common.entity.BaseDateEntity;
import com.grinder.domain.cart.model.Cart;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class CartEntity extends BaseDateEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Name(name = "회원 정보 연관 관계")
    private Long memberId;

    @Name(name = "카페 정보 연관 관계")
    private Long cafeId;

    @Name(name = "주문 여부", defaultValue = "false")
    private boolean isOrdered;


    public Cart toCart() {
        return Cart.builder()
                .id(id)
                .memberId(memberId)
                .cafeId(cafeId)
                .build();
    }
}
