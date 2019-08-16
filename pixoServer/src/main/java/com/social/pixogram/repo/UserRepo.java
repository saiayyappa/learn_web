package com.social.pixogram.repo;

import org.springframework.data.repository.CrudRepository;

import com.social.pixogram.model.User;

public interface UserRepo extends CrudRepository<User, Long>{

}
