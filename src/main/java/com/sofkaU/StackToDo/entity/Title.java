package com.sofkaU.StackToDo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Title")
@Table(name = "Title")
@Data
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Task> tasks = new ArrayList<>();

    public Title addTask(Task task){
        this.tasks.add(task);

        return this;
    }
}
