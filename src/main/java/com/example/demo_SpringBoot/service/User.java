package com.example.demo_SpringBoot.service;

import com.example.demo_SpringBoot.controller.dto.JobType;
import java.time.LocalDateTime;
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
    private JobType job;
    private String specialty;
    private LocalDateTime createdAt;
}
