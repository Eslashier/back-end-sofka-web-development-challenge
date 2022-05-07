package com.sofkaU.StackToDo.dto;

import lombok.Data;


@Data
public class TasksDTO {
    private Long id;
    private String taskToDo;
    private Boolean done;
    private Long fkTitleId;

}
