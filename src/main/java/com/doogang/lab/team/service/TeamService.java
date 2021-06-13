package com.doogang.lab.team.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doogang.lab.team.domain.Team;
import com.doogang.lab.team.domain.TeamRepository;
import com.doogang.lab.user.domain.User;
import com.doogang.lab.user.domain.UserRepository;
import com.doogang.lab.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {
	private final TeamRepository teamRepository;
	private final UserService userService;
	private final UserRepository userRepository;

	@Transactional
	public Team createTeam(Team team) {
		return teamRepository.save(team);
	}

	@Transactional(readOnly = true)
	public Team findTeamById(Long teamId) {
		return teamRepository.findById(teamId)
			.orElseThrow(() -> new EntityNotFoundException("team id에 해당하는 팀이 없습니다."));
	}

	@Transactional
	public boolean deleteUser(User user) {
		userRepository.deleteById(user.getId());
		return true;
	}
}
