package org.kodluyoruz.group1.library.model.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @CreationTimestamp
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    private boolean deleted;
}
