package com.taskapi.taskapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskapi.taskapi.core.entity.taskToDo.StatusTaskToDo;
import com.taskapi.taskapi.core.entity.taskToDo.TaskToDo;
import com.taskapi.taskapi.core.entity.taskToDo.TaskToDoDTO;
import com.taskapi.taskapi.core.services.TaskToDoService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/task")
public class TaskToDoController  {
    @Autowired
    private TaskToDoService taskToDoService; 

    
    @PostMapping
    public ResponseEntity<String> newTaskTodo(@RequestBody @Valid TaskToDoDTO data){
      return this.taskToDoService.newtaskToDo(data);
       
    }

    //atualiza uma tarefa
   @PutMapping("/{title}")
   public ResponseEntity<String> updateNewTaskToDo(@PathVariable @Valid String title, @RequestBody @Valid TaskToDo taskToDoDetails){
    return taskToDoService.updateTaskToDo(title, taskToDoDetails);
   }

   @GetMapping
   public ResponseEntity<ResponseEntity<Object>> listTaskTodo(){
    return ResponseEntity.ok().body(taskToDoService.listTaskToDo()); 
   }

   @GetMapping("/{id}")
   public ResponseEntity<ResponseEntity<Object>> findTaskTodoById(@PathVariable @Valid String id){
    return ResponseEntity.ok(taskToDoService.findTaskById(id));
   } 

   @DeleteMapping("/{id}")
   public ResponseEntity<ResponseEntity<String>> deleteTaskTodoById(@PathVariable @Valid String id){
    return ResponseEntity.ok().body(taskToDoService.deleteTaskToDoByid(id));
   }

   @PutMapping("/{title}/update")
   public ResponseEntity<Object> updateStatusTaskToDo(@PathVariable String title, @RequestBody StatusTaskToDo statusTaskToDo ){
      return ResponseEntity.ok().body(taskToDoService.updateStatusTaskToDo(statusTaskToDo, title));
   }
   
   //Lista Tarefas Por status
   @GetMapping("status/{status}")
   public ResponseEntity<Object> findByStatusTaskToDo(@PathVariable StatusTaskToDo status){
      return this.taskToDoService.listStatusTaskToDo(status);
   }
}
