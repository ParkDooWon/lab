package com.doogang.lab.team.dto;

import com.doogang.lab.team.domain.Campus;
import com.doogang.lab.team.domain.Team;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeamRequest {
	private String name;
	private Campus campus;

	public Team toEntity() {
		return Team.builder()
			.name(this.name)
			.campus(this.campus)
			.build();
	}
}
