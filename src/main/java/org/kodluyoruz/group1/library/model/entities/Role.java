package org.kodluyoruz.group1.library.model.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    private String roleName;

    private boolean deleted;

    @ManyToMany(mappedBy = "roles")
    private List<Member> members;

}
