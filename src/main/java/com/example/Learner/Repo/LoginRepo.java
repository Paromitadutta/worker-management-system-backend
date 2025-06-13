package com.example.Learner.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Learner.model.Login;

public interface LoginRepo extends JpaRepository<Login,Long>{

	
}
