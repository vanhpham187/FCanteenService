package fcantenn.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailKey implements Serializable {
    @Column(name = "order_id")
    int order_id;

    @Column(name = "user_id")
    int user_id;

    @Column(name = "dish_id")
    int dish_id;
}
