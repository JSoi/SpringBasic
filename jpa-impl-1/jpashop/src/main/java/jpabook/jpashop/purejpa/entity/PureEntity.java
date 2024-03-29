package jpabook.jpashop.purejpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PureEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int age;
}
