package main.springmvc.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Project name: agency
 * Created by bo4ek
 * Date: 09.12.2015
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
    private Collection<City> city;
}
