package com.taskapi.taskapi.core.entity.taskToDo;

import java.time.LocalDateTime;

public record TaskToDoDTO(String title , String description, LocalDateTime crationDate,StatusTaskToDo statusTaskToDo) {
    
}
