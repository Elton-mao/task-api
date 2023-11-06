package com.taskapi.taskapi.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taskapi.taskapi.core.domain.entity.TaskToDo;

import java.util.Optional;


public interface TaskRepository extends JpaRepository<TaskToDo,String>{
   //buscar uma tarefa pelo titulo
   Optional<TaskToDo> findByTitle(String title);
}
