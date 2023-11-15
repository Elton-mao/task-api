package com.taskapi.taskapi.core.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taskapi.taskapi.core.cases.task.TaskUseCase;
import com.taskapi.taskapi.core.entity.taskToDo.StatusTaskToDo;
import com.taskapi.taskapi.core.entity.taskToDo.TaskToDo;
import com.taskapi.taskapi.core.entity.taskToDo.TaskToDoDTO;
import com.taskapi.taskapi.infrastructure.repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class TaskToDoService implements TaskUseCase {
    @Autowired
    private TaskRepository taskRepository; 

    @Override
    public ResponseEntity<String> newtaskToDo(TaskToDoDTO data) {
        TaskToDo newTaskToDo = new TaskToDo();
        newTaskToDo.setTitle(data.title());
        newTaskToDo.setDescription(data.description());
        newTaskToDo.setStatusTaskToDo(data.statusTaskToDo());
        this.taskRepository.save(newTaskToDo);
        return ResponseEntity.ok().body("atividade criada com sucesso");
    }

    @Override
    public ResponseEntity<String> deleteTaskToDoByid(String id) {
      if (taskRepository.existsById(id)) {
       this.taskRepository.deleteById(id);
        }
      else {
        throw new NullPointerException("Nonexistent Record: The provided ID may not exist in the database, possibly due to deletion or an incorrect ID. " + id);
      }
      return ResponseEntity.ok().body("tarefa deletada com sucesso");
    }

    @Override
    public ResponseEntity<Object> listTaskToDo()  { 
      List<TaskToDo> listTaskToDo = taskRepository.findAll();
      if (listTaskToDo.isEmpty() == true) {
         throw new NullPointerException("An unexpected error occurred due to the absence of tasks in the database.");
      }
      return ResponseEntity.ok().body(listTaskToDo);
    }

    @Override
    public ResponseEntity<Object> findTaskById(String id) {
        Optional<TaskToDo> optionalTalskToDO = taskRepository.findById(id); 
        TaskToDo talskToDo = optionalTalskToDO.get();
        TaskToDoDTO taskToDoDTO = new TaskToDoDTO(talskToDo.getTitle(),talskToDo.getDescription(),talskToDo.getCrationDate(),talskToDo.getStatusTaskToDo());
        return ResponseEntity.ok().body(taskToDoDTO);       
        }

    @Override
    public ResponseEntity<String> updateTaskToDo(String title, TaskToDo taskToDoDetails) {
      try {
         Optional<TaskToDo> taskTodOptional = taskRepository.findByTitle(title);
        taskTodOptional.ifPresent(taskToDoUpdate ->{
        taskToDoUpdate.setTitle(taskToDoDetails.getTitle());
        taskToDoUpdate.setDescription(taskToDoDetails.getDescription());
        taskToDoUpdate.setCrationDate(LocalDateTime.now());
        taskRepository.save(taskToDoUpdate);  
        });
      } catch (NoSuchElementException e) {
          throw new EntityNotFoundException("erro ao atualizar tarefa verifique os campos e tente novamente");
      }    
        return ResponseEntity.ok().body("tarefa atualizada com Sucesso");
    }
    
    @Override
    public ResponseEntity<String> updateStatusTaskToDo(StatusTaskToDo statusTaskToDo, String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStatusTaskToDo'");
    }

    @Override
    public ResponseEntity<Object> listStatusTaskToDo(StatusTaskToDo status) {
        List<TaskToDo> taskToDoList = taskRepository.findByStatusTaskToDo(status);
        List<TaskToDoDTO> taskToDoDTOs = new ArrayList<>(); 
        for(TaskToDo task : taskToDoList ){
            TaskToDoDTO taskToDoDTO = new TaskToDoDTO(task.getTitle(),task.getDescription(),
             task.getCrationDate(), task.getStatusTaskToDo()); 
            taskToDoDTOs.add(taskToDoDTO);
        }
        return ResponseEntity.ok().body(taskToDoDTOs);
    }

    
  
}
