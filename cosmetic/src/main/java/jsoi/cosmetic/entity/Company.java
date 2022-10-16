package jsoi.cosmetic.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long id;

    @Column
    private String name;

    @OneToMany
    private List<Product> productList = new ArrayList<>();
}
