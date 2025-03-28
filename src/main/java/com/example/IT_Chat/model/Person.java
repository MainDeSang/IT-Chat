package com.example.IT_Chat.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity(name = "chat")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(nullable = false)
    private String email;
    private String password;
}
