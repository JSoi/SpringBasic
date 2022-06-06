package com.prac.week01.domain;

import com.prac.week01.models.PersonRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Person extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Person(PersonRequestDto personRequestDto) {
        this.name = personRequestDto.getName();
        this.age = personRequestDto.getAge();
        this.job = personRequestDto.getJob();
    }

    public void update(PersonRequestDto personRequestDto) {
        this.name = personRequestDto.getName();
        this.age = personRequestDto.getAge();
        this.job = personRequestDto.getJob();
    }
}
