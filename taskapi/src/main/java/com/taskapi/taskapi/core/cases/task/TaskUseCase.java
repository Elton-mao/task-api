package com.taskapi.taskapi.core.cases.task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.taskapi.taskapi.core.entity.taskToDo.StatusTaskToDo;
import com.taskapi.taskapi.core.entity.taskToDo.TaskToDo;

public interface TaskUseCase {

    //Cria uma entidade Task com os campos mencionados.
    public ResponseEntity<String> newtaskToDo(@RequestBody TaskToDo talskToDo);

    //Excluir uma tarefa por ID.
    public ResponseEntity<String> deleteTaskToDoByid(String id);
    
    //Listar todas as tarefas.
    public ResponseEntity<Object> listTaskToDo(); 

    //Recuperar uma tarefa específica por ID
    public ResponseEntity<Object> findTaskById(String id);
    
    //Atualizar uma tarefa existente
    public ResponseEntity<String> updateTaskToDo(String title,TaskToDo taskToDo); 
    
    //Adicione um campo de status à entidade Task para rastrear o status de uma tarefa
    public ResponseEntity<String> updateStatusTaskToDo(StatusTaskToDo statusTaskToDo, String title);

    //Lista Tarefas Por status 
    public ResponseEntity<Object> listStatusTaskToDo(String status); 
    

    }
