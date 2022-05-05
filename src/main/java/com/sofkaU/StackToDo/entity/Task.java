package com.sofkaU.StackToDo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Task")
@Table(name = "Task")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String task;

    private Boolean done;

    private Long fkTitleId;

}
