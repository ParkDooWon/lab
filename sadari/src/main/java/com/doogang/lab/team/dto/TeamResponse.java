package com.doogang.lab.team.dto;

import com.doogang.lab.team.domain.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class TeamResponse {
	private final Long id;
	private final String name;

	public static TeamResponse toResponse(Team team) {
		return TeamResponse.builder()
			.id(team.getId())
			.name(team.getName())
			.build();
	}
}
