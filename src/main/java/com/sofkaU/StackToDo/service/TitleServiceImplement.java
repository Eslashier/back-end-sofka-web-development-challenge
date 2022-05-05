package com.sofkaU.StackToDo.service;

import com.sofkaU.StackToDo.entity.Task;
import com.sofkaU.StackToDo.entity.Title;
import com.sofkaU.StackToDo.repository.TitleRepository;
import com.sofkaU.StackToDo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleServiceImplement implements TitleService{

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Title> getTitles() {
        return titleRepository.findAll();
    }

    @Override
    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }

    @Override
    public void deleteTitle(Title title) {
        Title titleToDelete = titleRepository.findById(title.getId()).get();
        if(titleToDelete.getTasks().size() >= 0){
            titleToDelete.getTasks().forEach(task -> taskRepository.deleteById(task.getId()));
        }
        titleRepository.deleteById(title.getId());
    }


    @Override
    public Title saveTask(Task task) {
        Title title = titleRepository.findById(task.getFkTitleId()).get();
        title.addTask(task);
        taskRepository.save(task);
        return titleRepository.save(title);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.deleteById(task.getId());
    }



}
