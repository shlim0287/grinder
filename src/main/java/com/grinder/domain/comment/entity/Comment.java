package com.grinder.domain.comment.entity;

import com.grinder.common.entity.BaseDateEntity;
import com.grinder.domain.feed.entity.Feed;
import com.grinder.domain.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseDateEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Feed feed;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MemberEntity memberEntity;

    @Column(nullable = false, length = 200)
    private String content;

    @Column(nullable = false)
    private Boolean isVisible;

    @ManyToOne
    private Comment parentComment;

    @PrePersist
    public void prePersist() {
        isVisible = isVisible == null || isVisible;
    }
}