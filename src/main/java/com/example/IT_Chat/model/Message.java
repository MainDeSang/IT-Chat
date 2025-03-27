package com.example.IT_Chat.model;

import lombok.*;

import java.security.Principal;
import java.sql.Timestamp;


@NoArgsConstructor
@Getter
@Setter
public class Message {
    private String user;
    private String text;
    private Timestamp timestamp;

    public Message(String text, Principal principal, Timestamp timestamp) {
        this.user = principal.getName();
        this.text = text;
        this.timestamp = timestamp;
    }
}
