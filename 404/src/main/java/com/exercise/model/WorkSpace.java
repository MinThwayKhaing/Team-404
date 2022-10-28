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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class WorkSpace implements Serializable 
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String name;
	@Column(columnDefinition = "tinyint(1) default 0")
    private boolean deleteStatus ;
	
//	@OneToMany(mappedBy = "workspace")
//    private List<Board> board = new ArrayList<>();
	@ManyToMany
    @JoinTable(
        name = "workspace_board",
        joinColumns = @JoinColumn( name = "workspace_id" ),
        inverseJoinColumns = @JoinColumn( name = "board_id" )
    )
    List<Board> workspaceBoard;

    @Transient
	@OneToMany(mappedBy = "workspace")
    private List<UserWorkSpace> userWorkspace = new ArrayList<>();
	
}
