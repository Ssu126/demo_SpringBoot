package com.example.demo_SpringBoot.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateRequestDto {

    @NotBlank
    private String name;
    @Min(10)
    private Integer age;
    @NonNull
    private JobType job;
    private String specialty = "(empty)";
}
