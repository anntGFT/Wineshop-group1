package com.gft.wineshop.models;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="wine")
// @NamedQuery(name="find_wine", query="select * from wine")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
