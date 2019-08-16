package com.social.pixogram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.pixogram.model.Blocked;
import com.social.pixogram.repo.BlockedRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BlockedController {

	@Autowired
	BlockedRepo blockedRepo;

//	@GetMapping(path = "/blocked")
//	public List<Blocked> getFollowers() {
//		System.out.println("Followings of all users...");
//		return (List<Blocked>) blockedRepo.findAll();
//	}

	@PostMapping(path = "/blocked/{userId}/{blockedId}")
	public Blocked block(@PathVariable("userId") Long userId, @PathVariable("blockedId") Long blockedId) {
		Blocked _blocked = blockedRepo.save(new Blocked(userId, blockedId));
		return _blocked;
	}

	@GetMapping(path = "/blocked/{userId}")
	public List<Blocked> getBlockedUsers(@PathVariable Long userId) {
		System.out.println("The user with id " + userId + "has blocked these Id's");
		List<Blocked> blocked = (List<Blocked>) blockedRepo.findAll();
		List<Blocked> _blocked = new ArrayList<>();

		for (Blocked block : blocked) {
			if (block.getUserId() == userId) {
				_blocked.add(block);
			}
		}
		return _blocked;
	}

	@DeleteMapping(path = "/unblocked/{userId}/{blockedId}")
	public ResponseEntity<String> unblock(@PathVariable("userId") long userId,
			@PathVariable("blockedId") Long blockedId) {
		List<Blocked> blocked = (List<Blocked>) blockedRepo.findAll();
		List<Blocked> _blocked = new ArrayList<>();
		List<Blocked> _blocked2 = new ArrayList<>();
		
		for (Blocked block : blocked) {
			if (block.getUserId() == userId) {
				_blocked.add(block);
			}
		}
		
		for (Blocked block : _blocked2) {
			if (block.getBlockedId() == blockedId) {
				blockedRepo.deleteById(block.getId());
			}
		}

		return new ResponseEntity<>("User has been unblocked", HttpStatus.OK);
	}
}
