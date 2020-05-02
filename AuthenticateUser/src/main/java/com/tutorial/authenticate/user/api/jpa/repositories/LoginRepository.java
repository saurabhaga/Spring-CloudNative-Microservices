package com.tutorial.authenticate.user.api.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tutorial.authenticate.user.api.entity.Login;

public interface LoginRepository extends  CrudRepository<Login, Integer> {

	Login findByUsernameAndPassword( String username, String pass);
}
