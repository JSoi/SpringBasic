package com.practice.demo.entity;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class MapStructEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value=EnumType.STRING)
    private TestV1 description;
    @LastModifiedDate
    private ZonedDateTime time;
}
