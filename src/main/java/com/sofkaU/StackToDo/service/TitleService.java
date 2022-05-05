package com.sofkaU.StackToDo.service;

import com.sofkaU.StackToDo.entity.Title;

import java.util.List;

public interface TitleService {

    List<Title> getTitles();

    Title saveTitle(Title title);

    void deleteTitle(Long id);

}
