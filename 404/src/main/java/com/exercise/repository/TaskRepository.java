package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.model.Card;
import com.exercise.model.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task,Integer>
{
	List <Task> findByCardIdAndDeleteStatus(int cardId,boolean deleteStatus);

	Task findByIdAndDeleteStatus(int taskId, boolean b);
}
