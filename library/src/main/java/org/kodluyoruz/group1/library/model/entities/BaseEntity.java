package org.kodluyoruz.group1.library.model.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "Created_Date", nullable = false ,updatable = false)
    @Column(name = "Created_Date", nullable = false)
    @CreationTimestamp
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Update_Date")
    private Date updateDate;

    @Column(name = "Deleted")
    private boolean deleted;


}
