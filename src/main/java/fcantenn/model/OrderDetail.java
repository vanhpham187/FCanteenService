package fcantenn.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
@Data
public class OrderDetail {
    @EmbeddedId
    private OrderDetailKey id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "order_id", updatable = false, insertable = false)
    private Order order;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "dish_id", updatable = false, insertable = false)
    private Dish dish;

    @Column(name = "quantity")
    private int quantity;
}
