package main.springmvc.model;

/**
 * Project name: agency
 * Created by bo4ek
 * Date: 09.12.2015
 */

import lombok.*;
import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;
}
