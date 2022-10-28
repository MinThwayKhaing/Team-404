package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exercise.model.Card;
import com.exercise.model.WorkSpace;
@Repository
public interface WorkspaceRepository  extends JpaRepository<WorkSpace,Integer>
{	
	public List<WorkSpace> findByIdAndDeleteStatus(int workspaceId,boolean b);
	@Query(value ="SELECT * from workspace_board t1 left join work_space t2 on t1.workspace_id=t2.id left join board t3 on t1.board_id=t3.id  where t1.workspace_id = ?1",nativeQuery = true)
	List<WorkSpace> findWorkspaceByWorkID(int id);
}
