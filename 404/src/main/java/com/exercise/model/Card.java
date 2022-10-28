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
import lombok.Getter;
import lombok.Setter;
@Entity
@Data
public class Card  implements Serializable
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String name;
	private String type;
	@Column(columnDefinition = "tinyint(1) default 0")
    private boolean deleteStatus ;


	
	@ManyToOne
    @JoinColumn(name="board_id")
    private Board board;
	
	@OneToMany(mappedBy = "card")
    private List<Task> task = new ArrayList<>();
}
