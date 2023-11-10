package com.taskapi.taskapi.core.entity.taskToDo;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class TaskToDo{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  String id;
    
    @NotBlank
    @Column(unique = true)
    private String title;

    @NotBlank
    private String description;

    private LocalDateTime crationDate = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusTaskToDo statusTaskToDo; 
    


}
