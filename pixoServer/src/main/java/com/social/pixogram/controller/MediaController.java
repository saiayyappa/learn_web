package com.social.pixogram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.social.pixogram.model.Media;
import com.social.pixogram.repo.MediaRepo;
import com.social.pixogram.repo.UserRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MediaController {

	@Autowired
	UserRepo userRepo;
	@Autowired
	MediaRepo mediaRepo;

	@GetMapping(path = "/media/{userId}")
	public List<Media> getUsers(@PathVariable int userId) {
		System.out.println("Get all media for the user " + userId);
		List<Media> medias = (List<Media>) mediaRepo.findAll();
		List<Media> _medias = new ArrayList<>();
		
		System.out.println(userId);
		System.out.println(medias);
		for (Media media : medias) {
			if (media.getUserId() == userId) {
				_medias.add(media);
			}
		}
		System.out.println(_medias);
		return _medias;
	}
}
