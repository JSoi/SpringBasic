package com.prac.week01.service;

import com.prac.week01.domain.Course;
import com.prac.week01.domain.CourseRepository;
import com.prac.week01.models.CourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;


    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려준다
    public Long update(Long id, CourseRequestDto requestDto) {
        Course course1 = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다"));
        course1.update(requestDto);
        return course1.getId();
    }
}
