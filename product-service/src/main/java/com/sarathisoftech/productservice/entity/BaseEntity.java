package com.sarathisoftech.productservice.entity;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Data
public class BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @CreationTimestamp
    @JsonIgnore
    public Timestamp createdDate;

    @Version
    @JsonIgnore
    public Timestamp lastUpdatedDate;
	
}