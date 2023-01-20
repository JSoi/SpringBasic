package com.practice.demo.mvc.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
public class MapStructEntityV2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value=EnumType.STRING)
    private TestV2 description;
    @LastModifiedDate
    private ZonedDateTime time;
}
