package jsoi.cosmetic.entity;

import jsoi.cosmetic.form.CommentUpdateForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public void updateComment(CommentUpdateForm commentUpdateForm) {
        this.star = commentUpdateForm.getStar();
        this.content = commentUpdateForm.getContent();
    }
}
