package com.gft.wineshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="wine")
// @NamedQuery(name="find_wine", query="select * from wine")
public class Wine {
    @Id
    @GeneratedValue

    private Integer id;
    private String name;
    private String year;
    
     @ManyToOne
    @JoinColumn(name = "winery_id")
    private Winery winery;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
