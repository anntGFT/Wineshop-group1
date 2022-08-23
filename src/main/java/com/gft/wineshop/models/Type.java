package com.gft.wineshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="type")
public class Type {
    @Id
    @GeneratedValue
    
    private Integer id;
    private String name;
}
