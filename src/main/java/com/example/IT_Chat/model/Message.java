package com.example.IT_Chat.model;

import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
public class Message {
    private String user;
    private String text;

    public Message(String user, String text) {
        this.user = user;
        this.text = text;
    }

}
