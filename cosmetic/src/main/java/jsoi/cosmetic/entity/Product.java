package jsoi.cosmetic.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long companyId;
    private Long userId;
    private Date productionDate;
    private Date expirationDate;
}
