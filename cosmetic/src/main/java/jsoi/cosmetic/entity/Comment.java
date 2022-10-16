package jsoi.cosmetic.entity;

import javax.persistence.*;

@Entity
@Table(name = "COMMENTS")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer star;

    @Column
    private String content;

}
