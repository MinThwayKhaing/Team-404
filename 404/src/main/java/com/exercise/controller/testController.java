package com.exercise.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exercise.dto.ActivityDTO;
import com.exercise.dto.BoardDTO;
import com.exercise.dto.CardDTO;
import com.exercise.dto.TaskDTO;
import com.exercise.model.Board;
import com.exercise.model.Task;
import com.exercise.repository.BoardRepository;
import com.exercise.repository.TaskRepository;
import com.exercise.service.ActivityService;
import com.exercise.service.BoardService;
import com.exercise.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class testController 
{
	@Autowired
	TaskService taskService;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	ActivityService activityService;
	
	@Autowired
	BoardService boardService;
	@GetMapping(value="/BoardTesting/{boardId}")
	public String  updateBoard(@PathVariable int boardId,ModelMap model)
	{
		boardId=1;
		//testing
		Board board=new Board();
		BoardDTO dto=new BoardDTO();
		
		dto.setBoardId(boardId);
		dto.setBoardName("Min");
		
		boardService.updateBoard(dto, boardId);
		return "test.html";
	}
	@GetMapping(value="/TaskTesting/{taskId}/{boardId}")
	public String showTask(@PathVariable int taskId,@PathVariable int boardId,ModelMap model) throws  ParseException
	{
//		CardDTO cardDto= new CardDTO();
//		cardDto.setCardId(cardId);
//		List<TaskDTO> taskList=taskService.showTask(cardDto);
//		model.addAttribute("taskList",taskList);
//		log.info(taskList.get(0).getName()+" "+taskList.get(1).getName());
		
		Board board=new Board();
	//	board.getWorkspace().getUser().getId();
		TaskDTO taskDto = new TaskDTO();
//		taskDto.setId(1);
//		taskDto.setName("Aung");
		taskDto.setStartDate("2022-10-18");
		taskDto.setEndDate("2022-10-20");
		taskDto.setStartTime("08:00 AM");
		taskDto.setEndTime("03:00 PM");
//		taskService.updateTask(taskDto, taskId);
		taskService.updateDate(taskDto,taskId);
		taskDto.setId(taskId);
		taskService.updateTaskForStatus(boardId, taskDto);
		
		
		
		
//			boardService.deleteBoard(cardId);
			
//			ActivityDTO dto=new ActivityDTO();
//			dto.setActivityName("ZZZ");
//			cardId=1;
//			activityService.insertActivity(cardId, dto);
//			
//		ActivityDTO dto=new ActivityDTO();
//		dto.setActivityName("ZZZ");
//		cardId=1;
//		activityService.updateActivity(cardId, dto);
		
//		activityService.Delete(cardId);
		
		
			return "test.html";
	}
}
