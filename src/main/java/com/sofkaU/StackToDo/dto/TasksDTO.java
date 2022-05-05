package com.sofkaU.StackToDo.dto;

import com.sofkaU.StackToDo.entity.Task;
import lombok.Data;

import java.util.List;

@Data
public class TasksDTO {
    private Long listId;
    private String listName;
    private List<Task> task;
}
