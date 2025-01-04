package com.grinder.domain.menu.entity;


import com.grinder.common.annotation.Name;
import com.grinder.common.entity.BaseDateEntity;
import com.grinder.domain.menu.model.Menu;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class MenuEntity extends BaseDateEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private Long price;
    
    private int stock;

    private boolean lockYn;
    
    @Name(name = "시즌 메뉴 여부")
    private boolean seasonYn;

    @Name(name = "화면에 보일 이미지 순서")
    private int sequence;

    @Name(name = "이미지 정보 연관 관계")
    private Long imageId;

    @Name(name = "카페 정보 연관 관계")
    private Long cafeId;

    @PrePersist
    public void prePersist() {
        this.lockYn = false;
    }

    public Menu toMenu() {
        return Menu.builder()
                .id(id)
                .description(description)
                .price(price)
                .stock(stock)
                .lockYn(lockYn)
                .seasonYn(seasonYn)
                .sequence(sequence)
                .imageId(imageId)
                .cafeId(cafeId)
                .build();
    }
}
