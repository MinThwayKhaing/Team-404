package com.exercise.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class UserWorkSpace implements Serializable
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@Column(columnDefinition = "tinyint(1) default 0")
    private boolean deleteStatus ;
	

	@ManyToOne
	@JoinColumn(name="workspace_id")
	private WorkSpace workspace;
	

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
}
