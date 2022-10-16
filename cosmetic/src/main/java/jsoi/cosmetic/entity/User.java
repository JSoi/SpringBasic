package jsoi.cosmetic.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String userId;

    @Column
    private String password;

    @OneToMany
    private List<UserProduct> productList = new ArrayList<>();


}
