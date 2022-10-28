package com.exercise.dto;

import java.util.List;

import com.exercise.model.Board;

import lombok.Data;

@Data
public class WorkSpaceBoardDTO 
{
	private int workspaceId;
	private String workspaceName;
//	private int boardId;
	//private String boardName;
	private List<Board> board;
}
