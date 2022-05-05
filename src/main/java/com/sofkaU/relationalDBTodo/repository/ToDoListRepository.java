package com.sofkaU.relationalDBTodo.repository;

import com.sofkaU.relationalDBTodo.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
