package com.grinder.domain.feed.entity;

import com.grinder.common.entity.BaseDateEntity;
import com.grinder.domain.cafe.entity.CafeEntity;
import com.grinder.domain.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Feed extends BaseDateEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private MemberEntity memberEntity;

    @ManyToOne
    @JoinColumn(name = "cafe_id")
    private CafeEntity cafeEntity;

    @Column(nullable = false, length = 2000)
    private String content;

    @Column(nullable = false)
    private Boolean isVisible;

    private Integer grade;

    @Column(name = "rank_value")
    private Integer rank;

}