package com.taskapi.taskapi.core.entity.taskToDo;

import java.time.LocalDateTime;

import org.springframework.boot.context.properties.bind.DefaultValue;

public record TaskToDoDTO(String title , String description, LocalDateTime crationDate,@DefaultValue("INPROGRESS") StatusTaskToDo statusTaskToDo) {
    
}
