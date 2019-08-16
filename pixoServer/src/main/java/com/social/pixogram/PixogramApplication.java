package com.social.pixogram;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.social.pixogram.model.Follow;
import com.social.pixogram.model.Media;
import com.social.pixogram.model.User;
import com.social.pixogram.repo.FollowRepo;
import com.social.pixogram.repo.MediaRepo;
import com.social.pixogram.repo.UserRepo;

@SpringBootApplication
public class PixogramApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixogramApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepo userRepo) {
		return args -> {
			Stream.of(new User("Sai", "sai@gmail.com", "root"), new User("Mani", "mani@gmail.com", "root"),
					new User("Dummy", "dummy@gmail.com", "root")).forEach(user -> {
						userRepo.save(user);
					});
			userRepo.findAll().forEach(System.out::println);
		};
	}

	@Bean
	ApplicationRunner init1(MediaRepo mediaRepo) {
		return args -> {
			Stream.of(new Media(1, "https://dummyimage.com/600x600/cfcfcf/"),
					new Media(1, "https://dummyimage.com/600x600/cfcfcf/"),
					new Media(2, "https://dummyimage.com/600x600/cfcfcf/"),
					new Media(2, "https://dummyimage.com/600x600/cfcfcf/")).forEach(media -> {
						mediaRepo.save(media);
					});
			mediaRepo.findAll().forEach(System.out::println);
		};
	}

	@Bean
	ApplicationRunner init2(FollowRepo followRepo) {
		return args -> {
			Stream.of(new Follow(1, 2), new Follow(1, 3), new Follow(2, 1), new Follow(3, 2)).forEach(follow -> {
				followRepo.save(follow);
			});
			followRepo.findAll().forEach(System.out::println);
		};
	}
}
