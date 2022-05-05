package com.sofkaU.relationalDBTodo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ToDoList")
@Table(name = "toDoList")
@Data
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String listName;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )

    private List<ToDoTask> todoTasks = new ArrayList<>();

    public ToDoList addToDoTask(ToDoTask toDoTask){
        this.todoTasks.add(toDoTask);

        return this;
    }


}
