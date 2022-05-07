package com.sofkaU.StackToDo.service;

import com.sofkaU.StackToDo.dto.TasksDTO;
import com.sofkaU.StackToDo.dto.TitleDTO;
import com.sofkaU.StackToDo.entity.Title;

import java.util.List;

public interface TitleService {

    List<TitleDTO> getAllTasks();

    Title createTitle(TitleDTO titleDTO);

    void deleteTitle(Long id);

    Title createTask(TasksDTO tasksDTo);

    Title updateTask(TasksDTO tasksDTO);

    void deleteTask(Long id);



}
