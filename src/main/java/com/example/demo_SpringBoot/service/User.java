package com.example.demo_SpringBoot.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class User {
    @Setter
    private Integer id;
    private String name;
    private Integer age;
    private String job;
    private String specialty;
}
