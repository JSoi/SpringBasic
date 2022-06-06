package com.prac.week01.service;

import com.prac.week01.domain.Person;
import com.prac.week01.domain.PersonRepository;
import com.prac.week01.models.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;
    @Transactional
    public Long update(Long id, PersonRequestDto requestDto){
        Person findPerson = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디를 가진 사람이 존재하지 않습니다"));
        findPerson.update(requestDto);
        return findPerson.getId();
    }
}
