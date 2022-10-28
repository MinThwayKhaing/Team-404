package com.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.dto.WorkspaceDTO;
import com.exercise.model.User;
import com.exercise.repository.UserRepository;
import com.exercise.repository.WorkspaceRepository;

@Service
public class UserService 
{
	@Autowired
	UserRepository userRepository;
	@Autowired
	WorkspaceRepository workspaceRepository;
	
	
}
