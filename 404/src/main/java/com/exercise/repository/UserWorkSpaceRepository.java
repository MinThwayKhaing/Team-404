package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.exercise.model.UserWorkSpace;
import com.exercise.model.WorkSpace;
import com.exercise.model.User;


@Repository
public interface UserWorkSpaceRepository extends JpaRepository<User,Integer>
{

	@Query(value="select workspace_id from user_work_space where user_id = ?1",nativeQuery=true)
	List<Integer> findByUserId(int userId);
	
}
