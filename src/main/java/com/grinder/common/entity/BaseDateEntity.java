package com.grinder.common.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseDateEntity implements Serializable {
    @CreatedDate
    @Column(updatable = false, nullable = false, length = 14)
    @Convert(converter = LclDtConverter.class)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(nullable = false, length = 14)
    @Convert(converter = LclDtConverter.class)
    private LocalDateTime modifiedDate;
}