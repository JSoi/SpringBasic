package com.prac.week01;

import com.prac.week01.domain.Course;
import com.prac.week01.domain.CourseRepository;
import com.prac.week01.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week01Application {

    public static void main(String[] args) {
        SpringApplication.run(Week01Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(CourseRepository repository, CourseService service) {
        return (args) -> {
            repository.save(new Course("프론트의 꽃, 리액트", "임민영"));
            System.out.println("데이터 인쇄");
            List<Course> result = repository.findAll();
            for (Course course : result) {
                System.out.println("course.getId() = " + course.getId());
                System.out.println("course.getTitle() = " + course.getTitle());
                System.out.println("course.getTutor() = " + course.getTutor());
            }

            Course newCourse = new Course("스프링", "남병관");
            repository.save(newCourse);
            List<Course> newresult = repository.findAll();
            for (Course course : newresult) {
                System.out.println("course.getId() = " + course.getId());
                System.out.println("course.getTitle() = " + course.getTitle());
                System.out.println("course.getTutor() = " + course.getTutor());
            }
        };
    }

}