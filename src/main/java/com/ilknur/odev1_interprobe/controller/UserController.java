package com.ilknur.odev1_interprobe.controller;

import com.ilknur.odev1_interprobe.model.User;
import com.ilknur.odev1_interprobe.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author İlknur Kara
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

	private final UserRepo userRepo;

	@PostMapping
	private User saveUser(@RequestBody User user) {
		return userRepo.save(user);
	}

	@DeleteMapping("/{userId}")
	private void deleteById(@PathVariable Long userId) {
		userRepo.deleteByUserId(userId);
	}




}
