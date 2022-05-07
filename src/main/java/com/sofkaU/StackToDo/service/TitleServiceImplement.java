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
    public Title createTitle(TitleDTO titleDTO) {
        Title newTitle = new Title();
        newTitle = convertDTOToTitle(titleDTO);
        return titleRepository.save(newTitle);
    }
    @Override
    public void deleteTitle(Long id) {
        titleRepository.deleteById(id);
    }

    @Override
    public Title createTask(TasksDTO tasksDTo) {
        Task newTask = new Task();
        newTask = convertDTOToTask(tasksDTo);
        Title title = titleRepository.findById(newTask.getFkTitleId()).get();
        title.addTask(newTask);
        taskRepository.save(newTask);
        return titleRepository.save(title);
    }

    @Override
    public Title updateTask(TasksDTO tasksDTO) {
        Task updatedTask = new Task();
        updatedTask = convertDTOToTask(tasksDTO);
        Title title = titleRepository.findById(updatedTask.getFkTitleId()).get();
        taskRepository.save(updatedTask);
        return titleRepository.save(title);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
