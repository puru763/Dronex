package com.dronex.mission_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootTest
class MissionServiceApplicationTests {


	@GetMapping("/test")
	public ResponseEntity<String> testEndpoint() {
		return ResponseEntity.ok("Test endpoint is working!");
	}

}
