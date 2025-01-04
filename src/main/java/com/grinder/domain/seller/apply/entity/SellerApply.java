package com.grinder.domain.seller.apply.entity;

import com.grinder.common.entity.BaseDateEntity;
import com.grinder.domain.cafe.entity.CafeEntity;
import com.grinder.domain.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SellerApply extends BaseDateEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MemberEntity memberEntity;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CafeEntity cafeEntity;

    private String regImageUrl;

}