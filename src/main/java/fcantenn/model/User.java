package fcantenn.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "salary", nullable = true)
    private Float salary;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "store_id", updatable = false, insertable = false)
    private Store store;


    @Column(name = "balance", nullable = true)
    private Float balance;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<OrderDetail> orderDetails;



    public String getFullName() {
        return first_name+ ' '+last_name;
    }
}
