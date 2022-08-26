package com.gft.wineshop.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
/*    private Float rating;
    private Integer num_reviews;
    private Float price;
    private Integer body;
    private Integer acidity;
    */
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
