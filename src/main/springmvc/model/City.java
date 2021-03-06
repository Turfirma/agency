package main.springmvc.model;

/**
 * City entity. Contain information about city.
 */

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@EqualsAndHashCode(exclude="cityId")
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_city", unique = true)
    private Integer cityId;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
    private Country country;
}
