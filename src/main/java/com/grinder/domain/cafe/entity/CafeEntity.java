package com.grinder.domain.cafe.entity;


import com.grinder.common.entity.BaseDateEntity;
import com.grinder.domain.cafe.model.Cafe;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class CafeEntity extends BaseDateEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private String description;

    private String tel;

    private String businessNumber;

    public Cafe toBasicInfo() {
        return Cafe.builder()
                .id(id)
                .name(name)
                .address(address)
                .description(description)
                .tel(tel)
                .build();
    }
}
