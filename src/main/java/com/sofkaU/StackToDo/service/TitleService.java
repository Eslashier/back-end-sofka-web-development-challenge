package com.sofkaU.StackToDo.service;

import com.sofkaU.StackToDo.entity.Task;
import com.sofkaU.StackToDo.entity.Title;

import java.util.List;

public interface TitleService {

    List<Title> getTitles();

    Title saveTitle(Title title);

    void deleteTitle(Title title);

    Title saveTask(Task task);

    void deleteTask(Task task);



}
