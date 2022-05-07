package com.sofkaU.StackToDo.service;

import com.sofkaU.StackToDo.dto.TasksDTO;
import com.sofkaU.StackToDo.dto.TitleDTO;
import com.sofkaU.StackToDo.entity.Task;
import com.sofkaU.StackToDo.entity.Title;
import com.sofkaU.StackToDo.repository.TitleRepository;
import com.sofkaU.StackToDo.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleServiceImplement implements TitleService{

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;

    private TitleDTO convertTitleToDTO(Title title){
        TitleDTO titleDTO;
        titleDTO = modelMapper.map(title, TitleDTO.class);
        return titleDTO;
    }

    private Title convertDTOToTitle(TitleDTO titleDTO){
        Title title = new Title();
        title = modelMapper.map(titleDTO, Title.class);
        return title;

    }

    private TasksDTO convertTaskToDTO(Task task){
        TasksDTO tasksDTO;
        tasksDTO = modelMapper.map(task, TasksDTO.class);
        return tasksDTO;
    }

    private Task convertDTOToTask(TasksDTO tasksDTO){
        Task task = new Task();
        task = modelMapper.map(tasksDTO, Task.class);
        return task;

    }

    @Override
    public List<TitleDTO> getAllTasks() {
        return titleRepository.findAll()
                .stream()
                .map(this::convertTitleToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteTitle(Long id) {
        titleRepository.deleteById(id);
    }


//    @Override
//    public Title createTask(Task task) {
//        Title title = titleRepository.findById(task.getFkTitleId()).get();
//        title.addTask(task);
//        taskRepository.save(task);
//        return titleRepository.save(title);
//    }

//    @Override
//    public Title updateTask(Task task) {
//        Title titleToUpdate = titleRepository.findById(task.getFkTitleId()).get();
//        taskRepository.save(task);
//        return titleRepository.save(titleToUpdate);
//    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
