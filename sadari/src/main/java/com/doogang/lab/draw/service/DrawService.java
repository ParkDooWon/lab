package com.doogang.lab.draw.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doogang.lab.user.domain.User;
import com.doogang.lab.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DrawService {
	private final UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<User> drawUser(int size) {
		return this.drawAllShuffledUsers().stream()
			.limit(size)
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Set<User> drawAllShuffledUsers() {
		List<User> allUsers = userRepository.findAll();
		return new HashSet<>(allUsers);
	}
}
