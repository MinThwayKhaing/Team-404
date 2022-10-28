package com.exercise.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Data
public class BoardDTO 
{
	
	private int boardId;
	private String boardName;
	private boolean deleteStatus;
	private int workspaceId;
}
