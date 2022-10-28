package com.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.dto.CardDTO;
import com.exercise.model.Board;
import com.exercise.model.Card;
import com.exercise.repository.BoardRepository;
import com.exercise.repository.CardRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CardService 
{

	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	CardRepository cardRepository;
	
	//CreateCustomCard
	public void createCustomCard(CardDTO cardDto,int boardId)
	{
		Card card=new Card();
		Board board=boardRepository.findById(boardId).get();
		
		card.setName(cardDto.getCardName());
		card.setType("custom");
		card.setBoard(board);
		cardRepository.save(card);
	}
	
	//update
	public void updateCustomCard(CardDTO cardDto,int cardId)
	{
		Card card=cardRepository.findByIdAndDeleteStatus(cardId,false);
		card.setName(cardDto.getCardName());
		cardRepository.save(card);
	}
	
	//delete 
	public void deleteCard(int cardId)
	{
		Card card=cardRepository.findByIdAndDeleteStatus(cardId,false);
		card.setDeleteStatus(true);
		cardRepository.save(card);
	}
	
	//showOne
	public CardDTO showOne(int cardId)
	{
		Card card=cardRepository.findByIdAndDeleteStatus(cardId, false);
		CardDTO dto=new CardDTO();
		dto.setCardId(cardId);
		dto.setCardName(card.getName());
		return dto;
	}
	
}
