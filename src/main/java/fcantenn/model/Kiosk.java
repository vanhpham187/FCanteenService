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

    public int getKiosk_id() {
        return kiosk_id;
    }

    public void setKiosk_id(int kiosk_id) {
        this.kiosk_id = kiosk_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }

    public Float getRental_fee() {
        return rental_fee;
    }

    public void setRental_fee(Float rental_fee) {
        this.rental_fee = rental_fee;
    }

    public Collection<Store> getStores() {
        return stores;
    }

    public void setStores(Collection<Store> stores) {
        this.stores = stores;
    }
}
