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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.dto.BoardDTO;
import com.exercise.dto.CardDTO;
import com.exercise.service.BoardService;
import com.exercise.service.CardService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CardController 
{
	@Autowired
	private CardService cardService;
	
	@Autowired
	private BoardService boardService;
	
	//showAllCard
	@GetMapping(value="/ShowAllCard/{boardId}")
	public ResponseEntity<List<CardDTO>> showCard(@PathVariable int boardId) throws NumberFormatException
	{
		List<CardDTO> card=boardService.showCard(boardId);
//		System.out.println("card ........"+card);
		
//			card=boardService.showCard(boardId);
			return ResponseEntity.ok(card);
	}
	
	//create Custom Card
	@PostMapping(value = "/Card/{boardId}", produces = "application/json")
	public CardDTO createCustomCard(@RequestBody CardDTO cardDto,@PathVariable int boardId) 
	{

		 	cardService.createCustomCard(cardDto,boardId);
		    return cardDto;
	}
	
	//delete
	@GetMapping(value="/CardDelete/{cardId}")
	public void cardDeleteCard(@PathVariable int cardId)
	{
		cardService.deleteCard(cardId);
	}
	
	//update
	@PutMapping(value="/Card/{cardId}")
	public void updateCustomCard(@RequestBody CardDTO cardDto,@PathVariable int cardId)
	{
		cardService.updateCustomCard(cardDto,cardId);
	}
	//showOne
	@GetMapping(value="/Card/{cardId}")
	public CardDTO showOne(@PathVariable int cardId)
	{
		CardDTO dto=cardService.showOne(cardId);
		return dto;
	}
}
