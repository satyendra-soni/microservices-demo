package com.sarathisoftech.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.sql.Timestamp;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    @JsonIgnore
    public Timestamp createdDate;

    @Version
    @JsonIgnore
    public Timestamp lastUpdatedDate;

}
