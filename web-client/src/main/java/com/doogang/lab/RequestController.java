package com.doogang.lab;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RequestController {
	@GetMapping("/sadari")
	public ResponseEntity<String> a() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity("http://localhost:8080", String.class, Collections.emptyMap());
	}
}
