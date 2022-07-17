package fcantenn.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "kiosk")
@Data
public class Kiosk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kiosk_id")
    private int kiosk_id;

    @Column(name = "location")
    private String location;

    @Column(name = "owner_name")
    private String owner_name;

    @Column(name = "owner_phone")
    private String owner_phone;

    @Column(name = "rental_fee")
    private Float rental_fee;

    @OneToMany(mappedBy = "kiosk", cascade = CascadeType.ALL)
    private Collection<Store> stores;
}
