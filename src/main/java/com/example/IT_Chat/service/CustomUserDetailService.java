package com.example.IT_Chat.service;

import com.example.IT_Chat.model.Person;
import com.example.IT_Chat.repository.PersonRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class CustomUserDetailService implements UserDetailsService {

    PersonRepository personRepository;


    public CustomUserDetailService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }  // Constructor injection for PersonRepository.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user = personRepository.findByName(username);
        System.out.println(user.getPassword());
        return org.springframework.security.core.userdetails.User.builder().username(username).password("{noop}" + user.getPassword()).passwordEncoder((str) -> str).authorities("USER").build();
    }
}
