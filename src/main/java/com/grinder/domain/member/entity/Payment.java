package com.grinder.domain.member.entity;

import com.grinder.common.entity.BaseDateEntity;
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
public class Payment extends BaseDateEntity {
    @Id
    @GeneratedValue
    private Long id;

    //TODO: 정확한 정보는 추후 확인
}
