package jsoi.cosmetic.entity;

import javax.persistence.*;

@Entity
public class Comment extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer star;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public void setProduct(Product product) {
        this.product = product;
    }
}
