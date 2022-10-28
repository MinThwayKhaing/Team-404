package com.exercise.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDTO 
{
	private int id;
	private String name;
	private String startDate;
	private String endDate;
	private int cardId;
	private String status;
	private String startTime;
	private String endTime;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
}
