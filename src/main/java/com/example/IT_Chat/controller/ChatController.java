package com.example.IT_Chat.controller;

import com.example.IT_Chat.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
@AllArgsConstructor
public class ChatController {

    private final List<Message> messages = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("messages", messages);
        return "index";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam String text, Principal principal, Timestamp timestamp) {
        messages.add(new Message(text, principal, timestamp));
        return "redirect:/";
    }
}
