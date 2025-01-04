package com.grinder.domain.menu.entity;


import com.grinder.common.annotation.Name;
import com.grinder.common.entity.BaseDateEntity;
import com.grinder.domain.menu.model.Option;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "options")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class OptionEntity extends BaseDateEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long price;

    private int stock;

    private boolean lockYn;

    @Name(name = "메뉴 정보 연관 관계", description = "메뉴 선택 시 나오는 소메뉴")
    private Long menuId;

    @PrePersist
    public void prePersist() {
        this.lockYn = false;
    }

    public Option toOption() {
        return Option.builder()
                .id(id)
                .name(name)
                .price(price)
                .stock(stock)
                .lockYn(lockYn)
                .menuId(menuId)
                .build();
    }
}
