package com.grinder.domain.order.entity;

import com.grinder.common.annotation.Name;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class OrderMenuInfo {
    @Id
    @GeneratedValue
    private Long id;

    @Name(name = "주문 연관 관계")
    private Long orderId;

    @Name(name = "메뉴 리스트 연관 관계")
    private Long menuId;
}
