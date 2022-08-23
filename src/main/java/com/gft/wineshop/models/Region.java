package com.gft.wineshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="region")
public class Region {
    @Id
    @GeneratedValue
    
    private Integer id;
    private String name;
    private String country;
}
