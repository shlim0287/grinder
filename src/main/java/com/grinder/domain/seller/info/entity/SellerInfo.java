package com.grinder.domain.seller.info.entity;

import com.grinder.domain.cafe.entity.CafeEntity;
import com.grinder.domain.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SellerInfo {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MemberEntity memberEntity;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CafeEntity cafeEntity;
}