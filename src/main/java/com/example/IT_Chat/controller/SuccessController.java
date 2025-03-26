package com.example.IT_Chat.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/success")
@AllArgsConstructor
public class SuccessController {

    @GetMapping()
    public String showSuccess(Model model, @RequestParam String username) {
        model.addAttribute("name" , username);
        return "success";
    }



}
