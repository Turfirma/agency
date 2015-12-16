package main.springmvc.model;

import com.sun.istack.internal.NotNull;
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
    @NotNull
    private String countryName;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<City> city;
}
