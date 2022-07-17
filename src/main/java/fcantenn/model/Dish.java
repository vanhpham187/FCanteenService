package fcantenn.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "dish")
@Data
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int dish_id;

    @Column(name = "dish_name")
    private String dish_name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String image_url;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private Collection<OrderDetail> orderDetails;
}
