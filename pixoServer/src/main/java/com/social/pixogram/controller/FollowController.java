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

import com.social.pixogram.model.Follow;
import com.social.pixogram.repo.FollowRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FollowController {

	@Autowired
	FollowRepo followRepo;

	@PostMapping(path = "/follow/{userId}/{followId}")
	public Follow follow(@PathVariable("userId") Long userId, @PathVariable("followId") Long followId) {
		System.out.println("Added follower");
		Follow _follow = followRepo.save(new Follow(userId, followId));
		return _follow;
	}

	@GetMapping(path = "/followings/{userId}")
	public List<Follow> followings(@PathVariable Long userId) {
		
		List<Follow> follow = (List<Follow>) followRepo.findAll();
		List<Follow> _follow = new ArrayList<>();
		
		for(Follow f : follow) {
			if(f.getUserId() == userId)
				_follow.add(f);
		}
		
		return _follow;
		
	}
	
	@GetMapping(path = "/followers/{followId}")
	public List<Follow> followers(@PathVariable("followId") Long followId) {
		
		List<Follow> follow = (List<Follow>) followRepo.findAll();
		List<Follow> _follow = new ArrayList<>();
		
		for(Follow f : follow) {
			if(f.getfollowId()== followId)
				_follow.add(f);
		}
		
		return _follow;
	}

	@DeleteMapping(path = "/unfollow/{userId}/{followId}")
	public ResponseEntity<String> unfollow(@PathVariable("userId") long userId, @PathVariable("followId") long followId) {
		
		List<Follow> follow = (List<Follow>) followRepo.findAll();
		List<Follow> _follow = new ArrayList<>();
		List<Follow> _follow2 = new ArrayList<>();
		
		for(Follow f : follow) {
			if(f.getUserId() == userId)
				_follow.add(f);
		}
		
		for(Follow f : _follow2) {
			if(f.getfollowId() == followId)
				followRepo.deleteById(f.getId());
		}
		
		return new ResponseEntity<>("Unfollowed", HttpStatus.OK);
	}
}
