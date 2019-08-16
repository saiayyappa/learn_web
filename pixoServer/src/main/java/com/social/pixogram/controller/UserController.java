package com.social.pixogram.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.pixogram.model.User;
import com.social.pixogram.repo.UserRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	UserRepo userRepo;

	@GetMapping(path = "/users")
	public List<User> getUsers() {
		System.out.println("Get all Users...");
		return (List<User>) userRepo.findAll();
	}

	@PostMapping(path = "/user/create")
	public User createUser(@RequestBody User user) {
		System.out.println("Creating User");
		User _user = userRepo.save(new User(user.getName(), user.getEmail(), user.getPassword()));
		return _user;
	}

	@GetMapping(path = "/user/{userId}")
	public Optional<User> getUserById(@PathVariable Long userId) {
		System.out.println("Get user with id " + userId);
		return (Optional<User>) userRepo.findById(userId);
	}

}
