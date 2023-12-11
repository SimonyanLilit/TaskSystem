package com.taskmanagmentsystem.model;

import com.taskmanagmentsystem.enums.Priority;
import com.taskmanagmentsystem.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    private Integer id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @OneToOne
    @JoinColumn(name="author_id",referencedColumnName = "id")
    private UserEntity AuthorEntity;

    @OneToOne
    @JoinColumn(name="executor_id",referencedColumnName = "id")
    private UserEntity executorEntity;
}
