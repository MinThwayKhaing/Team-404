package com.exercise.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RestController;

import com.exercise.dto.CardDTO;
import com.exercise.dto.TaskDTO;
import com.exercise.repository.TaskRepository;
import com.exercise.service.CardService;
import com.exercise.service.TaskService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TaskController 
{
	@Autowired
	private CardService cardService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private TaskRepository taskRepository;
	
	//insert card
	@PostMapping(value = "/Task")
	public TaskDTO createTask(@RequestBody TaskDTO taskDto) 
	{

		 	taskService.createTask(taskDto);
		    return new TaskDTO();
	}
	
	//showTask
	@GetMapping(value="/Task/{cardId}")
	public ResponseEntity<List<TaskDTO>> showTask(@PathVariable int cardId) throws NumberFormatException, ParseException
	{
		
		CardDTO cardDto= new CardDTO();
		cardDto.setCardId(cardId);
		List<TaskDTO> card=taskService.showTask(cardDto);
//		System.out.println("card ........"+card);
		
			return ResponseEntity.ok(card);
	}
	
	//if Date added 
	@PostMapping(value = "/Task/addDate/{boardId}")
	public TaskDTO addDate(@PathVariable int boardId,@RequestBody TaskDTO taskDto) throws ParseException 
	{
			taskService.addDateTime(taskDto);
			taskService.updateTaskForStatus(boardId,taskDto);
		    return new TaskDTO();
	}
	
	//update
	@PutMapping(value="TaskUpdate/{taskId}")
	public void Update(@PathVariable int taskId,@RequestBody TaskDTO taskDto)
	{
		taskService.updateTask(taskDto, taskId);
	}
	//showOneTask
	@GetMapping(value="TaskShowOne/{taskId}")
	public TaskDTO ShowOne(@PathVariable int taskId)
	{
		TaskDTO dto=taskService.showOne(taskId);
		return dto;
	}
	//delete
	@GetMapping(value="/Task/Delete/{taskId}")
	public void Delete (@PathVariable int taskId)
	{
		taskService.delete(taskId);
	}
	
	//dateUpdate
	@PostMapping(value="TaskDateUpdate/{taskId}")
	public void updateTaskDate(@PathVariable int taskId,@RequestBody TaskDTO taskDto) throws ParseException
	{
		taskService.updateDate(taskDto,taskId);
	}
	
}
