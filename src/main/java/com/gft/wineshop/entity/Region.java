package com.gft.wineshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="region")
public class Region {
    @Id
    @GeneratedValue
    
    private Integer id;
    private String name;
    private String country;
}
