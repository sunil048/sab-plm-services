package com.sabtok.plm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class Traceable {

    @Transient
    private String user = "sab-kharcha-service";

    @Column(name="CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name="CREATED_BY")
    private String createdBy;

    @PrePersist
    public void prePersist() {

        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (createdBy == null) {
            createdBy = user;
        }
    }

}
