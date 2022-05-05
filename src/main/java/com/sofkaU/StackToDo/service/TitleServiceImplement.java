package com.sofkaU.StackToDo.service;

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
    public void deleteTitle(Long id) {
        titleRepository.deleteById(id);
    }

}
