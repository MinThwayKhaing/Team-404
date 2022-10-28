package com.exercise.service;
import com.exercise.model.UserWorkSpace;
import com.exercise.model.WorkSpace;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.model.UserWorkSpace;
import com.exercise.dto.UserWorkSpaceDTO;
import com.exercise.dto.WorkspaceDTO;
import com.exercise.repository.UserWorkSpaceRepository;

@Service
public class UserWorkSpaceService {
	
	@Autowired
	UserWorkSpaceRepository uwsr;
	
	public List<Integer> workspaceIdFromUser(int userId)
	{
		List<WorkspaceDTO> list=new ArrayList();
		List<Integer> workspaceId=uwsr.findByUserId(userId);
		return workspaceId;
	}
}
