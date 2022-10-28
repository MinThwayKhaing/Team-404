package com.exercise.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.dto.ActivityDTO;
import com.exercise.dto.WorkSpaceBoardDTO;
import com.exercise.dto.WorkspaceDTO;
import com.exercise.service.BoardService;
import com.exercise.service.WorkspaceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class WorkspaceController 
{
	@Autowired
	WorkspaceService workspaceService;
	
	@Autowired
	BoardService boardService;
	
	//ShowAll
		@GetMapping(value="/showAll/{userId}")
		public ResponseEntity<List<WorkSpaceBoardDTO>> showAllActivity(@PathVariable int userId)
		{
			List<WorkSpaceBoardDTO>list= workspaceService.showAll(userId);
			return ResponseEntity.ok(list);
		}
	
	
}
