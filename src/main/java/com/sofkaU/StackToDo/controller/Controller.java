package com.sofkaU.StackToDo.controller;

import com.sofkaU.StackToDo.dto.TasksDTO;
import com.sofkaU.StackToDo.dto.TitleDTO;
import com.sofkaU.StackToDo.entity.Task;
import com.sofkaU.StackToDo.entity.Title;
import com.sofkaU.StackToDo.service.TitleService;
import com.sofkaU.StackToDo.service.TitleServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/")
public class Controller {

    @Autowired
    private TitleServiceImplement service;

    @GetMapping("get/titles")
    public List<TitleDTO> getAllTasks(){
        return service.getAllTasks();
    }

    @PostMapping("create/titles")
    public Title createTitle(@Valid @RequestBody TitleDTO titleDTO){
        return service.createTitle(titleDTO);
    }

    @PostMapping("create/tasks")
    public Title createTask(@Valid @RequestBody TasksDTO tasksDTO){
        return service.createTask(tasksDTO);
    }
//
//    @PutMapping("update/task")
//    public Title updateTask(@Valid @RequestBody Task task){
//        return service.updateTask(task);
//    }

    @DeleteMapping("delete/title/{id}")
    public void deleteTitle(@PathVariable Long id){
        service.deleteTitle(id);
    }

    @DeleteMapping("delete/task/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }

}
