package com.sofkaU.relationalDBTodo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "ToDoTask")
@Table(name = "toDoTask")
@Data
public class ToDoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String task;

    private Boolean done;

    private Long fkToDoListId;
}
