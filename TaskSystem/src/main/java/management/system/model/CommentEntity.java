package management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import management.system.common.costants.Constants;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = Constants.COMMENT_TABLE_NAME, schema = Constants.SCHEMA_NAME)
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {

    @Id
    @Column(name = "task_id")
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID commentId;
    private String text;

    @OneToOne
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    private TaskEntity task;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;
}
