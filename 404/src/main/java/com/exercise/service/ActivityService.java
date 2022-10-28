package com.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.dto.ActivityDTO;
import com.exercise.dto.TaskDTO;
import com.exercise.model.Activity;
import com.exercise.model.Task;
import com.exercise.repository.ActivityRepository;
import com.exercise.repository.TaskRepository;

@Service
public class ActivityService 
{
	@Autowired
	ActivityRepository activityRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	//insert 
	public void insertActivity (int taskId,ActivityDTO activityDto)
	{
		Activity activity=new Activity();
		Task task=taskRepository.findById(taskId).get();
		activity.setName(activityDto.getActivityName());
		activity.setTask(task);
		activityRepository.save(activity);
	}
	
	//update
	public void updateActivity(int activityId,ActivityDTO dto)
	{
		Activity activity=activityRepository.findByIdAndDeleteStatus(activityId,false);
		activity.setId(activityId);
		activity.setName(dto.getActivityName());
		activityRepository.save(activity);
	}
	
	//showAll
	public List<ActivityDTO> showAll(int taskId)
	{
		List<Activity> act=activityRepository.findByTaskIdAndDeleteStatus(taskId, false);
		List<ActivityDTO> list=new ArrayList<>();
		for(Activity a: act)
		{
		ActivityDTO dto=new ActivityDTO();
		dto.setActivityName(a.getName());
		list.add(dto);
		}
		return list;
	}
	
	//showOne
	public ActivityDTO showOne(int activityId)
	{
		Activity act =activityRepository.findByIdAndDeleteStatus(activityId, false);
		ActivityDTO dto=new ActivityDTO();
		dto.setActivityId(act.getId());
		dto.setActivityName(act.getName());
		return dto;
	}
	
	//delete
	
	public void Delete(int activityId)
	{
		Activity act =activityRepository.findByIdAndDeleteStatus(activityId, false);
		act.setDeleteStatus(true);
		activityRepository.save(act);
	}
}
