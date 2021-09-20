package com.doogang.lab.user.dto;

import com.doogang.lab.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UserResponse {
	private final Long id;
	private final String name;
	private final Long teamId;

	public static UserResponse toResponse(User user) {
		return UserResponse.builder()
			.id(user.getId())
			.name(user.getName())
			.teamId(user.getTeam().getId())
			.build();
	}
}
