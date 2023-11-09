package com.taskapi.taskapi.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskapi.taskapi.core.entity.taskToDo.StatusTaskToDo;
import com.taskapi.taskapi.core.entity.taskToDo.TaskToDo;

import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<TaskToDo,String>{
   //buscar uma tarefa pelo titulo
   Optional<TaskToDo> findByTitle(String title);
   
   
   List<TaskToDo> findByStatusTaskToDo(StatusTaskToDo status);
   

}
