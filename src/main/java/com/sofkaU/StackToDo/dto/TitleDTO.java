package com.sofkaU.StackToDo.dto;

import com.sofkaU.StackToDo.entity.Task;
import lombok.Data;

import java.util.List;

@Data
public class TitleDTO {
    private Long id;
    private String name;
    private List<Task> todo;
}
