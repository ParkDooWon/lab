package com.doogang.lab.member.controller.dto;

import com.doogang.lab.member.domain.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {
	private String name;

	public User toEntity() {
		return User.builder()
			.name(this.name)
			.build();
	}
}