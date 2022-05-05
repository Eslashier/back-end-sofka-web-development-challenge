package com.sofkaU.relationalDBTodo.repository;

import com.sofkaU.relationalDBTodo.entity.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoTaskRepository extends JpaRepository<ToDoTask, Long>{
}
