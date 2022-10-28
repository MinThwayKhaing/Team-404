package com.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.dto.WorkSpaceBoardDTO;
import com.exercise.dto.WorkspaceDTO;
import com.exercise.model.WorkSpace;
import com.exercise.repository.UserWorkSpaceRepository;
import com.exercise.repository.WorkspaceRepository;

@Service
public class WorkspaceService 
{
	@Autowired
	WorkspaceRepository workspaceRepository;
	
	@Autowired
	UserWorkSpaceService us;
	
	public List<WorkSpaceBoardDTO> showAll(int userId)
	{
		List<WorkSpaceBoardDTO> list=new ArrayList<>();
		List<Integer> id=us.workspaceIdFromUser(userId);
		WorkSpaceBoardDTO dto=new WorkSpaceBoardDTO();
		System.out.print(id);
		for(int i:id)
		{
			List<WorkSpace> wb=workspaceRepository.findWorkspaceByWorkID(i);
			for(WorkSpace w:wb)
			{
				
				dto.setBoard(w.getWorkspaceBoard());
				dto.setWorkspaceId(w.getId());
				dto.setWorkspaceName(w.getName());
			}
			list.add(dto);
		}
		 return list;
	}
	
}
