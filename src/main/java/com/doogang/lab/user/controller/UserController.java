package com.doogang.lab.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doogang.lab.team.domain.Team;
import com.doogang.lab.team.domain.TeamRepository;
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
	private final TeamRepository teamRepository;

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

	@GetMapping("/teams/users")
	public ResponseEntity<Boolean> getUsers() {
		List<Team> all = teamRepository.findAll();
		for (Team team : all) {
			for (User user : team.getUsers()) {
				System.err.println(user.getId());
				// team에 2명의 user가 있다고 할 때, 각 user를 조회할때마다 user 테이블을 select하진 않는다.
				// 즉, team.getUsers().get(0)일 때 1번의 select, team.getUsers().get(1)일 때 1번의 select 이렇진않다.
			}
		}
		return ResponseEntity.ok(Boolean.TRUE);
	}
}
