package com.exercise.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.dto.CardDTO;
import com.exercise.dto.TaskDTO;
import com.exercise.model.Card;
import com.exercise.model.Task;
import com.exercise.repository.CardRepository;
import com.exercise.repository.TaskRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskService 
{
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	CardRepository cardRepository;
	
	
	//task update
	public void updateTask(TaskDTO taskDto,int taskId)
	{
		Task task=taskRepository.findByIdAndDeleteStatus(taskId, false);
		task.setName(taskDto.getName());
		task.setCard(cardRepository.findByIdAndDeleteStatus(taskDto.getCardId(), false));
		task.setStartDate(taskDto.getStartDate());
		task.setEndDate(taskDto.getEndDate());
		taskRepository.save(task);
	}
	//task Create
	public void createTask(TaskDTO taskDto)
	{
		Task task=new Task();
		
		task.setName(taskDto.getName());
		task.setCard(cardRepository.findById(taskDto.getCardId()).get());
		task.setStartDate(taskDto.getStartDate());
		task.setEndDate(taskDto.getEndDate());
		taskRepository.save(task);
	}
	//Date time change
	
	 public static String englishTime(String input)
	            throws ParseException {

	        // Format of the date defined in the input String
	        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");

	        // Change the pattern into 24 hour format
	        DateFormat format = new SimpleDateFormat("HH:mm");
	        Date time = null;
	        String output = "";

	        // Converting the input String to Date
	        time = dateFormat.parse(input);

	        // Changing the format of date
	        // and storing it in
	        // String
	        output = format.format(time);
	        return output;
	    }
	//change to 24hours format
	    public String twelveHourFormat(String time) throws ParseException {

	        final SimpleDateFormat sdf = new SimpleDateFormat("h:mm");
	        final Date dateObj = sdf.parse(time);

//	        log.info(new SimpleDateFormat("hh:mm a").format(dateObj));
	        return new SimpleDateFormat("hh:mm a").format(dateObj);
	    }
	
	    //showTask
	public List<TaskDTO> showTask(CardDTO cardDto) throws ParseException
	{
		List<Task> taskList= taskRepository.findByCardIdAndDeleteStatus(cardDto.getCardId(), false);
		List <TaskDTO>taskDTOList=new ArrayList();
		 for (Task task : taskList)
		 {
	            TaskDTO taskDto1 = new TaskDTO();
	            taskDto1.setId(task.getId());
	            taskDto1.setName(task.getName());
	            taskDto1.setStartDate(task.getStartDate());
	            if(task.getStartTime()!= null) {
	            	taskDto1.setStartTime(twelveHourFormat(task.getStartTime()));
	            }
	            if(task.getEndTime()!= null) {
	            	taskDto1.setEndTime(twelveHourFormat(task.getEndTime()));
	            }
	            taskDto1.setEndDate(task.getEndDate());
	            taskDto1.setCardId(task.getCard().getId());
	            taskDTOList.add(taskDto1);
		 }
		return taskDTOList;
	}
	
	//if date added
	public void addDateTime(TaskDTO taskDto) throws ParseException {
		Task task = new Task();
		task.setId(taskDto.getId());
		task.setStartDate(taskDto.getStartDate());
		task.setEndDate(taskDto.getEndDate());
		task.setStartTime(englishTime(taskDto.getStartTime()));
		task.setEndTime(englishTime(taskDto.getEndTime()));
		taskRepository.save(task);
	}
	//update date
	public void updateDate(TaskDTO taskDto,int taskId) throws ParseException
	{
		Task task=taskRepository.findByIdAndDeleteStatus(taskId,false);
		task.setId(taskId);
		task.setStartDate(taskDto.getStartDate());
		task.setEndDate(taskDto.getEndDate());
		task.setStartTime(englishTime(taskDto.getStartTime()));
		task.setEndTime(englishTime(taskDto.getEndTime()));
		taskRepository.save(task);
	}
	//status Condition
	public TaskDTO setTaskAfterAddDate(TaskDTO taskDto) {
		
		Task task = taskRepository.findById(taskDto.getId()).get();
		
		taskDto.setStartDate(task.getStartDate());
		taskDto.setStartTime(task.getStartTime());
		taskDto.setEndDate(task.getEndDate());
		taskDto.setEndTime(task.getEndTime());
		
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
		taskDto.setStartDateTime(
                LocalDateTime.parse(taskDto.getStartDate() + " " + taskDto.getStartTime(), dtf));

		taskDto.setEndDateTime(LocalDateTime.parse(taskDto.getEndDate() + " " + taskDto.getEndTime(), dtf));
        
		if (taskDto.getStartDateTime().isAfter(LocalDateTime.now())) {
            taskDto.setStatus("TO DO");
        }

        else if (LocalDateTime.now().isAfter(taskDto.getEndDateTime())) {
        	taskDto.setStatus("Done");
        }
   
        else if (LocalDateTime.now().isAfter(taskDto.getStartDateTime())
                && LocalDateTime.now().isBefore(taskDto.getEndDateTime())) {
        	taskDto.setStatus("Doing");
        }
		
		return taskDto;
	}
	
	//if card name == status change the foreign
	public void updateTaskForStatus(int boardId,TaskDTO taskDto) {
		List<Card> cardList = cardRepository.findAllByBoardIdAndTypeAndDeleteStatus(boardId,"default", false);
		TaskDTO taskDto1 = setTaskAfterAddDate(taskDto);
		for(Card card: cardList) {
		//	log.info(card.getName());
			if(card.getName().equalsIgnoreCase(taskDto.getStatus())) {
				Task task1 = taskRepository.findById(taskDto.getId()).get();
				task1.setCard(card);
				//log.info(task1.getId()+"");
				taskRepository.save(task1);
			}
		}
	}
	
	//showOne
	public TaskDTO showOne(int taskId) 
	{
		Task task=taskRepository.findByIdAndDeleteStatus(taskId, false);
		TaskDTO dto=new TaskDTO();
		dto.setId(taskId);
		dto.setName(task.getName());
		
		return dto; 
		
	}
	//delete 
	public void delete(int taskId)
	{
		Task task=taskRepository.findByIdAndDeleteStatus(taskId,false);
		task.setDeleteStatus(true);
		taskRepository.save(task);
	}
}
