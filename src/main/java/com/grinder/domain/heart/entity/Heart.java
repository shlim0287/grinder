package com.grinder.domain.heart.entity;

import com.grinder.domain.heart.model.ContentType;
import com.grinder.domain.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(indexes = {
        @Index(name = "idx_content_type", columnList = "content_type")
})
@NoArgsConstructor
@AllArgsConstructor
public class Heart {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MemberEntity memberEntity;

    @Column(nullable = false)
    private Long contentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type", nullable = false, length = 16)
    private ContentType contentType;
}