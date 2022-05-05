package com.sofkaU.relationalDBTodo.service;


import com.sofkaU.relationalDBTodo.entity.List;
import com.sofkaU.relationalDBTodo.entity.Task;
import org.springframework.stereotype.Service;

@Service
public interface ListService {

    List createList(List list);

    List createTask(Task task);

    List updateTask(Task task);

    void deleteTask(Task task);

    void deleteList(List list);

    java.util.List<List> findAllLists();
}
