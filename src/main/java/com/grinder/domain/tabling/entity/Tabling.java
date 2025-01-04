package com.grinder.domain.tabling.entity;


import com.grinder.common.annotation.Name;
import com.grinder.common.entity.BaseDateEntity;
import com.grinder.domain.tabling.model.StatusType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class Tabling extends BaseDateEntity {
    @Id
    @GeneratedValue
    private Long id;

    private int CurrentNumber;

    private int MaxNumber;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    private String reason;

    @Name(name = "카페 정보 연관 관계")
    private Long CafeId;
}
