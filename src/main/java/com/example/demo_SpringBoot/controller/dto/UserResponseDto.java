package com.example.demo_SpringBoot.controller.dto;

import com.example.demo_SpringBoot.service.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class UserResponseDto {
    private Integer id;
    private String name;
    private Integer age;
    private String job;
    private String specialty;
    private String address;
    private String postcode;

    public static UserResponseDto from(User entity) {
        return new UserResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getJob(),
                entity.getSpecialty(),
                null,
                null
        );
    }
}
