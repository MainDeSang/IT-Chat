package com.example.IT_Chat.controller;

import com.example.IT_Chat.model.Person;
import com.example.IT_Chat.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/register")
@AllArgsConstructor

public class PersonController {

    private final PersonService personService;

    @GetMapping()
    public String showRegistration(Model model) {
        model.addAttribute("person" , new Person());
        return "/register";
    }
    @PostMapping()
    public String registerPerson(Person person) {
        personService.registerPerson(person);
        return "redirect:/success?username="+person.getName();
    }

}
