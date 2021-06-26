package com.doogang.lab.user.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doogang.lab.team.domain.Team;
import com.doogang.lab.user.domain.User;
import com.doogang.lab.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;

	@Transactional
	public User registerUser(User user, Team team) {
		user.updateTeam(team);
		return userRepository.save(user);
	}

	public User findById(Long userId) {
		return userRepository.findById(userId)
			.orElseThrow(() -> new EntityNotFoundException("user_id에 해당하는 유저가 없습니다."));
	}

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
