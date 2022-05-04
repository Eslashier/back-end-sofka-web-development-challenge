package com.sofkaU.relationalDBTodo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "ToDoList")
@Table(name = "toDoList")
@Data
public class ToDoList {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String listName;


}
