package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.exercise.model.Task;
import com.exercise.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	

}
