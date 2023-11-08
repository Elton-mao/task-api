package com.taskapi.taskapi.core.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taskapi.taskapi.core.cases.task.TaskUseCase;
import com.taskapi.taskapi.core.domain.entity.StatusTaskToDo;
import com.taskapi.taskapi.core.domain.entity.TaskToDo;
import com.taskapi.taskapi.infrastructure.repository.TaskRepository;
@Service
public class TaskToDoService implements TaskUseCase {
    @Autowired
    private TaskRepository taskRepository; 

    @Override
    public ResponseEntity<String> newtaskToDo(TaskToDo talskToDo) {
        taskRepository.save(talskToDo);
        return ResponseEntity.ok("tarefa Criada com Suceso");
    }

    @Override
    public ResponseEntity<String> deleteTaskToDoByid(String id) {
      taskRepository.deleteById(id);
      return ResponseEntity.ok().body("tarefa deletada com sucesso");
    }

    @Override
    public ResponseEntity<Object> listTaskToDo()  {
      List<TaskToDo> listTaskToDo = taskRepository.findAll();
      return ResponseEntity.ok().body(listTaskToDo);
    }

    @Override
    public ResponseEntity<Object> findTaskById(String id) {
        Optional<TaskToDo> optionalTalskToDO = taskRepository.findById(id); 
        TaskToDo talskToDo = optionalTalskToDO.get();
        return ResponseEntity.ok().body(talskToDo);
        
        }

    @Override
    public ResponseEntity<String> updateTaskToDo(String title, TaskToDo taskToDoDetails) {
        Optional<TaskToDo> taskTodOptional = taskRepository.findByTitle(title);
        TaskToDo taskToDoUpdate = taskTodOptional.get(); 
        taskToDoUpdate.setTitle(taskToDoDetails.getTitle());
        taskToDoUpdate.setDescription(taskToDoDetails.getDescription());
        taskToDoUpdate.setCrationDate(LocalDateTime.now());
        taskRepository.save(taskToDoUpdate);
        return ResponseEntity.ok().body("tarefa atualizada com Sucesso"); 
    }
    
    @Override
    public ResponseEntity<String> updateStatusTaskToDo(StatusTaskToDo statusTaskToDo, String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStatusTaskToDo'");
    }

    @Override
    public ResponseEntity<Object> listStatusTaskToDo(String status) {
        List<TaskToDo> taskToDoList = taskRepository.findByStatusTaskToDo(status);
        return ResponseEntity.ok().body(taskToDoList);
    }
    
  
}
