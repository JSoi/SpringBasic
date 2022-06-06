package com.prac.week01.domain;

import com.prac.week01.models.CourseRequestDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Course extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String tutor;

    public void update(CourseRequestDto courseRequestDto) {
        this.title = courseRequestDto.getTitle();
        this.tutor = courseRequestDto.getTutor();
    }

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }
    public Course(CourseRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
    public String getTitle() {
        return this.title;
    }

    public String getTutor() {
        return this.tutor;
    }
}
