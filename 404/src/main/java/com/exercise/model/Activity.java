package com.exercise.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Activity implements Serializable
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String name;
	
	@Column(columnDefinition = "tinyint(1) default 0")
    private boolean deleteStatus ;
	
	@ManyToOne
    @JoinColumn(name="task_id")
    private Task task;
	
	 @OneToMany(mappedBy = "activity")
	    private List<Attached> attached= new ArrayList();
}
