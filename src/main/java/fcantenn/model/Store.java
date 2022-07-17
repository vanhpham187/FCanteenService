package fcantenn.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "store")
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int store_id;

    @Column(name = "hotline")
    private String hotline;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "manager_id")
    private User manager;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "kiosk_id")
    private Kiosk kiosk;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private Collection<Dish> dishes;
}
