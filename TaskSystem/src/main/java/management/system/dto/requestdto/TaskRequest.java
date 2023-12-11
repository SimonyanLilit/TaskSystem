package management.system.dto.requestdto;

import lombok.Getter;
import lombok.Setter;
import management.system.enums.Priority;
import management.system.enums.Status;

import java.util.UUID;

@Getter
@Setter
public class TaskRequest {

    private String title;
    private String description;
    private Status status;
    private Priority priority;
}
