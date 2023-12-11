package management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import management.system.common.costants.Constants;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = Constants.USER_TABLE_NAME, schema = Constants.SCHEMA_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "user_id")
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String surname;
    private String email;
    private String password;

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
