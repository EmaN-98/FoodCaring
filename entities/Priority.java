package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="priority")
public class Priority{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "id_user_deprived")
    private UUID id_user_deprived;

    @Column(name = "name")
    private String name;

    @Column(name = "priority")
    private Integer priority;

    public Priority(){

    }

    public Priority(UUID id_user_deprived, String name, Integer priority) {
        this.id_user_deprived = id_user_deprived;
        this.name = name;
        this.priority = priority;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId_user_deprived() {
        return id_user_deprived;
    }

    public void setId_user_deprived(UUID id_user_deprived) {
        this.id_user_deprived = id_user_deprived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}

