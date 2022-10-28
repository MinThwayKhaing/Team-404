package com.exercise.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.exercise.dto.BoardDTO;
import com.exercise.dto.CardDTO;
import com.exercise.dto.WorkspaceDTO;
import com.exercise.model.Board;
import com.exercise.model.WorkSpace;
import com.exercise.service.BoardService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class BoardController 
{
	@Autowired
	private BoardService boardService;
		
	//insert 
	@PostMapping(value = "/boards/{workspaceId}", produces = "application/json")
	public BoardDTO createBoard(@RequestBody BoardDTO boardDto,@PathVariable int workspaceId) 
	{
		
//		System.out.println("board name controller: "+boardDto.getName());
		 	boardService.createBoard(boardDto,workspaceId);
		 	boardService.createCardAfterBoard();
		    return boardDto;
	}
	
//	update
	@PutMapping(value="/Board/{boardId}")
	public ResponseEntity<BoardDTO> updateBoard(@PathVariable int boardId,@RequestBody BoardDTO dto)
	{
//		boardId=1;
//		//testing
//		dto.setBoardId(boardId);
//		dto.setBoardName("Min");
//		
		boardService.updateBoard(dto, boardId);
		return ResponseEntity.ok(dto);
	}
	
	//delete
	@GetMapping(value="/DeleteBoard/{boardId}")
	public void deleteBoard(@PathVariable int boardId)
	{
		boardService.deleteBoard(boardId);
	}
}
