package com.prac.week01.controller;

import com.prac.week01.domain.Course;
import com.prac.week01.domain.CourseRepository;
import com.prac.week01.models.CourseRequestDto;
import com.prac.week01.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseRepository courseRepository;
    private final CourseService courseService;

    @GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto) {
        return courseRepository.save(new Course(requestDto));
    }

    @PutMapping("/api/courses/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.update(id, requestDto);
    }

    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return id;
    }
}
