package com.grinder.domain.cart.model;

import com.grinder.domain.cafe.entity.CafeEntity;
import com.grinder.domain.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartInformation {
    private MemberEntity memberEntity;
    private CafeEntity cafeEntity;
}