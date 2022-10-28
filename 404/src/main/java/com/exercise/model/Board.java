package com.exercise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Board implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@Column(length=8129)
	private String name;
	//private String date;
	@Column(columnDefinition = "tinyint(1) default 0")
    private boolean deleteStatus ;
	
	@OneToMany(mappedBy = "board")
    private List<Card> card = new ArrayList<>();
	
//	@ManyToOne
//	@JoinColumn(name="workspace_id",referencedColumnName = "id")
//	private WorkSpace workspace;
}
