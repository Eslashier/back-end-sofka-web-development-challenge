package com.sofkaU.relationalDBTodo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Task")
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String task;

    private Boolean done;

    private Long fkListId;
}
