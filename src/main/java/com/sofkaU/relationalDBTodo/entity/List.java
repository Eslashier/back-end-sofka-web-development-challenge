package com.sofkaU.relationalDBTodo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity(name = "List")
@Table(name = "list")
@Data
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String listName;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )

    private java.util.List<Task> tasks = new ArrayList<>();

    public List addToDoTask(Task task){
        this.tasks.add(task);

        return this;
    }


}
