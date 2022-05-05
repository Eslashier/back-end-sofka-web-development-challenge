package com.sofkaU.StackToDo.service;

import com.sofkaU.StackToDo.dto.TasksDTO;
import com.sofkaU.StackToDo.entity.Task;
import com.sofkaU.StackToDo.entity.Title;

import java.util.List;

public interface TitleService {

    List<Title> getTitles();

    List<TasksDTO> getAllTasks();

    Title createTitle(Title title);

    void deleteTitle(Long id);

    Title createTask(Task task);

    Title updateTask(Task task);

    void deleteTask(Long id);



}
