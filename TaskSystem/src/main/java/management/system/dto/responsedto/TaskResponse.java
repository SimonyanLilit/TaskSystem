package management.system.dto.responsedto;

import lombok.Getter;
import lombok.Setter;
import management.system.enums.Priority;
import management.system.enums.Status;
import management.system.model.UserEntity;

@Getter
@Setter
public class TaskResponse {
    private String taskId;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private UserEntity author;
    private UserEntity assignee;
}
