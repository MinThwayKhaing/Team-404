package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.dto.ActivityDTO;
import com.exercise.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Integer>
{

	Activity findByIdAndDeleteStatus(int activityId,boolean b);

	List<Activity> findByTaskIdAndDeleteStatus(int taskId, boolean b);

	
	
}
