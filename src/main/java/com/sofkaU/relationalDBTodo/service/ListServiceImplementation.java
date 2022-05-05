package com.sofkaU.relationalDBTodo.service;

import com.sofkaU.relationalDBTodo.entity.List;
import com.sofkaU.relationalDBTodo.entity.Task;
import com.sofkaU.relationalDBTodo.repository.ListRepository;
import com.sofkaU.relationalDBTodo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListServiceImplementation implements ListService {

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List createList(List list) {
        return listRepository.save(list);
    }

    @Override
    public List createTask(Task task) {
        List list = listRepository.findById(task.getFkListId()).get();
        list.addToDoTask(task);
        taskRepository.save(task);
        return listRepository.save(list);
    }

    @Override
    public List updateTask(Task task) {
        return null;
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.deleteById(task.getId());
    }

    @Override
    public void deleteList(List list) {
       List listToDelete = listRepository.findById(list.getId()).get();
       if(listToDelete.getTasks().size()>=0){
           listToDelete.getTasks().forEach(task -> taskRepository.deleteById(task.getId()));
       }
       listRepository.deleteById(list.getId());
    }

    @Override
    public java.util.List<List> findAllLists() {
        return listRepository.findAll();
    }
}
