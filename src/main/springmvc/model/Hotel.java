package main.springmvc.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

/**
 * Hotel entity. Contain information about Hotel.
 */
@Getter
@Setter
@EqualsAndHashCode(exclude="hotelId")
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_hotel", unique = true)
    private Integer hotelId;

    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    @ManyToOne
    @JoinColumn(name = "id_city", nullable = false)
    private City city;

/*    @OneToMany(mappedBy = "hotels", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Room> rooms;*/
}
