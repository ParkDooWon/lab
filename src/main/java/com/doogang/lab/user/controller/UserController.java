package com.doogang.lab.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doogang.lab.team.domain.Team;
import com.doogang.lab.team.service.TeamService;
import com.doogang.lab.user.domain.User;
import com.doogang.lab.user.dto.UserRequest;
import com.doogang.lab.user.dto.UserResponse;
import com.doogang.lab.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {
	private final UserService userService;
	private final TeamService teamService;

	@PostMapping("/teams/{teamId}/users")
	public ResponseEntity<UserResponse> register(@PathVariable Long teamId, @RequestBody UserRequest userRequest) {
		Team team = teamService.findTeamById(teamId);
		User user = userService.registerUser(userRequest.toEntity(), team);
		return ResponseEntity.ok(UserResponse.toResponse(user));
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long userId) {
		User user = userService.findById(userId);
		teamService.deleteUser(user);
		return ResponseEntity.ok().build();
	}
}
