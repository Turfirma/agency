package main.springmvc.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

/**
 * Country entity. Contain information about Country.
 */
@Setter
@Getter
@EqualsAndHashCode(exclude = "countryId")
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_country", unique = true)
    private Integer countryId;

    @Column(name = "country_name",unique = true, nullable = false)
    private String countryName;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<City> city;
}
