package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exercise.dto.BoardDTO;
import com.exercise.model.Board;
import com.exercise.model.WorkSpace;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer>
{
		@Query(value = "SELECT `id` FROM `board` ORDER BY `id` DESC LIMIT 1",
				nativeQuery= true)
		public Integer selectLastRow();
		public Board findByIdAndDeleteStatus(int boardId, boolean b);

}
