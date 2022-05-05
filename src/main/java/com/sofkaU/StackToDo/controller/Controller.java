package com.sofkaU.StackToDo.controller;

import com.sofkaU.StackToDo.entity.Task;
import com.sofkaU.StackToDo.entity.Title;
import com.sofkaU.StackToDo.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class Controller {

    @Autowired
    private TitleService service;

    @GetMapping("get/titles")
    public List<Title> getAllTitles(){
        return service.getTitles();
    }

    @PostMapping("create/titles")
    public Title createTitle(@RequestBody Title title){
        return service.createTitle(title);
    }

    @PostMapping("create/tasks")
    public Title createTask(@RequestBody Task task){
        return service.createTask(task);
    }

    @PutMapping("update/task")
    public Title updateTask(@RequestBody Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("delete/title/{id}")
    public void deleteTitle(@PathVariable Long id){
        service.deleteTitle(id);
    }

    @DeleteMapping("delete/task/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }

}
