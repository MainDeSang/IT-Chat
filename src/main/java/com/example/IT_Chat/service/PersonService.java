package com.example.IT_Chat.service;

import com.example.IT_Chat.model.Person;
import com.example.IT_Chat.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
@AllArgsConstructor

public class PersonService {

    private final PersonRepository persoRepository;

    public void registerPerson(Person person) {
        if(person.getName() == null || person.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(person.getPassword() == null || person.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password cannot be empty and has to be at least 6 characters");
        }
        if(person.getEmail() == null || person.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        persoRepository.save(person);
    }
}
