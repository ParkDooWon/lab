package com.doogang.lab.common;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public class BaseTimeEntity {
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime modifiedAt;
}
