package com.doogang.lab.draw.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doogang.lab.draw.service.DrawService;
import com.doogang.lab.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/draw")
@RequiredArgsConstructor
@RestController
public class DrawController {
	private final DrawService drawService;

	@GetMapping("/all")
	public ResponseEntity<Set<User>> drawAllUser() {
		return ResponseEntity.ok(drawService.drawAllShuffledUsers());
	}

	@GetMapping
	public ResponseEntity<List<User>> drawUser(@RequestParam(defaultValue = "1") int size) {
		List<User> users = drawService.drawUser(size);

		return ResponseEntity.ok(users);
	}
}
