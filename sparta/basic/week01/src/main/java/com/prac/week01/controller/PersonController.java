package com.prac.week01.controller;

import com.prac.week01.domain.Person;
import com.prac.week01.domain.PersonRepository;
import com.prac.week01.domain.Timestamped;
import com.prac.week01.models.PersonRequestDto;
import com.prac.week01.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController extends Timestamped {
    private final PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping("/api/persons")
    public List<Person> showpersons() {
        return personRepository.findAll();
    }

    @PostMapping("api/persons")
    public Person addPersons(@RequestBody PersonRequestDto personRequestDto) {
        return personRepository.save(new Person(personRequestDto));
    }

    @PutMapping("/api/persons/{id}")
    public Long editPersons(@PathVariable Long id, @RequestBody PersonRequestDto personRequestDto) {
        return personService.update(id, personRequestDto);

    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return id;
    }
}
