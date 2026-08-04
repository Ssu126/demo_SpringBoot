package com.example.demo_SpringBoot.controller.dto;

import com.example.demo_SpringBoot.service.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"userid", "username"})
public class UserResponseDto {

    @JsonProperty("userId")
    private Integer id;
    @JsonProperty("username")
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
