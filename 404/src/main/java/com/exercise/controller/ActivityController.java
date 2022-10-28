package com.exercise.controller;

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

import com.exercise.dto.ActivityDTO;
import com.exercise.service.ActivityService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ActivityController 
{
	@Autowired
	private ActivityService activityService;
	
	//save
	@PostMapping(value="/Activity/{taskId}")
	public void InsertActivity(@PathVariable int taskId,@RequestBody ActivityDTO dto)
	{
		activityService.insertActivity(taskId, dto);
	}
	//update
	@PutMapping(value="/Activity/{activityId}")
	public void updateActivity(@PathVariable int activityId,@RequestBody ActivityDTO dto)
	{
		activityService.updateActivity(activityId, dto);
	}
	//ShowAll
	@GetMapping(value="/ActivityShowAll/{taskId}")
	public ResponseEntity<List<ActivityDTO>> showAllActivity(@PathVariable int taskId)
	{
		List<ActivityDTO>list= activityService.showAll(taskId);
		return ResponseEntity.ok(list);
	}
	
	//ShowOne
	@GetMapping(value="/ActivityShow/{activityId}")
	public ResponseEntity<ActivityDTO> showOneActivity(@PathVariable int activityId)
	{
		ActivityDTO dto=activityService.showOne(activityId);
		return ResponseEntity.ok(dto);
	}
	
	//delete
	@GetMapping(value="/Delete/{activityId}")
	public void Delete(@PathVariable int activityId)
	{
		activityService.Delete(activityId);
	}
}
