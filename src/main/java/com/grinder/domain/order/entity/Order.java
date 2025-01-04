package com.grinder.domain.order.entity;

import com.grinder.common.annotation.Name;
import com.grinder.common.entity.BaseDateEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class Order extends BaseDateEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Name(name = "회원 정보 연관 관계(메뉴 정보 관련)")
    private Long memberId;

    @Name(name = "카페 정보 연관 관계(메뉴 정보 관련)")
    private Long cafeId;

    @Name(name = "결제 정보 연관 관계")
    private Long orderPaymentId;
}
