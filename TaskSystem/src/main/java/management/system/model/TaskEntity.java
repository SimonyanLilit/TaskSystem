package management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import management.system.common.costants.Constants;
import management.system.enums.Priority;
import management.system.enums.Status;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = Constants.TASK_TABLE_NAME, schema = Constants.SCHEMA_NAME)
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {

    @Id
    @Column(name = "task_id")
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID taskId;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "user_id")
    private UserEntity author;
    @OneToOne
    @JoinColumn(name = "assignee_id", referencedColumnName = "user_id")
    private UserEntity assignee;

}
