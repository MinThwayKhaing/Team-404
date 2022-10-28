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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;
@Entity
@Data
public class User implements Serializable 
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String name;
	@Column(columnDefinition = "tinyint(1) default 0")
    private boolean deleteStatus ;
	
	@OneToMany(mappedBy = "user")
    private List<UserWorkSpace> userWorkspace = new ArrayList<>();
	
	@ManyToMany
    @JoinTable(
        name = "user_board",
        joinColumns = @JoinColumn( name = "user_id" ),
        inverseJoinColumns = @JoinColumn( name = "board_id" )
    )
    List<Board> userBoard;

    @Transient
    private int board;
 

}
