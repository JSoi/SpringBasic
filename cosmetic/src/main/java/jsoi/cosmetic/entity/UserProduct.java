package jsoi.cosmetic.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserProduct {
    @Id
    @Column(name="USER_PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMPANY_ID")
    private Company company;

    private Date purchaseDate;
    private Date productionDate;
    private Date expirationDate;
}
