package com.doogang.lab.draw.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class DrawController {
	@GetMapping
	public ResponseEntity<Boolean> register() {
		return ResponseEntity.ok(Boolean.TRUE);
	}
}
