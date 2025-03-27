package com.example.IT_Chat.controller;
import com.example.IT_Chat.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/overview")
@AllArgsConstructor
public class OverviewController {

    private final PersonRepository personRepository;

   @GetMapping()
    public String showOverview(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "/overview";
    }
    @PostMapping("/delete")
    public String deletePerson(@RequestParam Long id) {
        personRepository.deleteById(id);
        return "redirect:/overview";
    }
}
