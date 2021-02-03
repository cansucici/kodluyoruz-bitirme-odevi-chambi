package org.kodluyoruz.group1.library.model.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {
<<<<<<< HEAD:library/src/main/java/org/kodluyoruz/group1/library/model/entities/BaseEntity.java

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "create_date", nullable = false)
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

>>>>>>> 031bd0211c132b6fe69d4b40f4b61f5ec1fc23d1:src/main/java/org/kodluyoruz/group1/library/model/entities/BaseEntity.java
    @CreationTimestamp
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
<<<<<<< HEAD:library/src/main/java/org/kodluyoruz/group1/library/model/entities/BaseEntity.java
    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "deleted")
=======
    @UpdateTimestamp
    private Date updateDate;

>>>>>>> 031bd0211c132b6fe69d4b40f4b61f5ec1fc23d1:src/main/java/org/kodluyoruz/group1/library/model/entities/BaseEntity.java
    private boolean deleted;
}
