package com.exercise.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.dto.BoardDTO;
import com.exercise.dto.CardDTO;
import com.exercise.dto.UserWorkSpaceDTO;

import com.exercise.dto.WorkspaceDTO;
import com.exercise.model.Board;
import com.exercise.model.Card;
import com.exercise.model.Task;
import com.exercise.model.UserWorkSpace;
import com.exercise.model.WorkSpace;
import com.exercise.repository.BoardRepository;
import com.exercise.repository.CardRepository;
import com.exercise.repository.UserWorkSpaceRepository;
import com.exercise.repository.WorkspaceRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService 
{
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	CardRepository cardRepository;
	@Autowired
	WorkspaceRepository  wpR;

	@Autowired
	UserWorkSpaceRepository uwsr;
	
	@Autowired
	UserWorkSpaceService uwsrService;
	
	
	
	 //insert
	 public void  createBoard(BoardDTO boardDto,int workspaceId)
	 {
		 	Board board=new Board();
		 	WorkSpace wp=(WorkSpace) wpR.findByIdAndDeleteStatus(workspaceId,false);
		 	board.setName(boardDto.getBoardName());
//			System.out.println("board name : "+boardDto.getName());
//		 	board.setDate(boardDto.getDate());
		 	boardRepository.save(board);
	 }
	 
	 //update
	 public void updateBoard(BoardDTO dto,int boardId)
	 {
		 Board board=boardRepository.findByIdAndDeleteStatus(boardId, false);
		 board.setId(dto.getBoardId());
		 board.setName(dto.getBoardName());
		 boardRepository.save(board);
	 }
	 
	
	 //delete
	 public void deleteBoard(int boardId)
	 {
		 Board board=boardRepository.findByIdAndDeleteStatus(boardId, false);
		
		 board.setDeleteStatus(true);
		 boardRepository.save(board);
	 }
	 //card generate
	 public void createCardAfterBoard()
	 {
		 int boardId=boardRepository.selectLastRow(); 
		 Board board=new Board();
		 board.setId(boardId);
		 
		 Card card=new Card();
		 card.setName("TO DO");
		 card.setType("default");
		 card.setBoard(board);
		 cardRepository.save(card);
		 
		 Card card1=new Card();
		 card1.setName("Doing");
		 card1.setType("default");
		 card1.setBoard(board);
		 cardRepository.save(card1);
		 
		 Card card2=new Card();
		 card2.setName("Done");
		 card2.setType("default");
		 card2.setBoard(board);
		 cardRepository.save(card2);
		 
	 }
	 
	 //cardshow
	 public List<CardDTO> showCard (int  boardId)
	 {
		 
		 List <CardDTO>cardDTOList=new ArrayList <CardDTO>();
		 List<Card> cardList=cardRepository.findAllByBoardIdAndDeleteStatus(boardId, false);
		 for (Card card : cardList) {
	            CardDTO cardDto = new CardDTO();
	            cardDto.setCardId(card.getId());
	            cardDto.setCardName(card.getName());
	            cardDto.setType(card.getType());
	            cardDTOList.add(cardDto);
	          
		 }
		 return cardDTOList;
	 }
	    
}
