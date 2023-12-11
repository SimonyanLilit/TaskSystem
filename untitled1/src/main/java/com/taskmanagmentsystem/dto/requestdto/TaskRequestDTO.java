package com.taskmanagmentsystem.dto.requestdto;

import com.taskmanagmentsystem.enums.Priority;
import com.taskmanagmentsystem.enums.Status;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class TaskRequestDTO {
    private Integer id;
    private String requestTitle;
    private String requestDescription;
    @Enumerated(EnumType.STRING)
    private Status requestStatus;
    @Enumerated(EnumType.STRING)
    private Priority requestPriority;
    private String requestExecutorEmail;
}
