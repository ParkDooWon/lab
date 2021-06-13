package com.doogang.lab.team.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doogang.lab.team.domain.Team;
import com.doogang.lab.team.dto.TeamRequest;
import com.doogang.lab.team.dto.TeamResponse;
import com.doogang.lab.team.service.TeamService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TeamController {
	private final TeamService teamService;

	@PostMapping("/teams")
	public ResponseEntity<TeamResponse> createTeam(@RequestBody TeamRequest teamRequest) {
		Team team = teamService.createTeam(teamRequest.toEntity());
		TeamResponse response = TeamResponse.toResponse(team);
		return ResponseEntity.ok(response);
	}
}
