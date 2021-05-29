package com.doogang.lab.draw.controller.dto;

import com.doogang.lab.draw.domain.CellType;
import com.doogang.lab.draw.domain.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {
	private String name;
	private CellType cellType;

	public User toEntity() {
		return User.builder()
			.name(this.name)
			.cellType(this.cellType)
			.build();
	}
}
