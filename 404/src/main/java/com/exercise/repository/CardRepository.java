package com.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer>
{
	public List<Card> findAllByBoardIdAndDeleteStatus(int boardId,boolean deleteStatus);
	public List<Card> findAllByBoardIdAndTypeAndDeleteStatus(int boardId,String type,boolean deleteStatus);
	public Card findByIdAndDeleteStatus(int cardId,boolean b);

}
