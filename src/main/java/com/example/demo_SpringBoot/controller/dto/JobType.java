package com.example.demo_SpringBoot.controller.dto;

import com.example.demo_SpringBoot.exception.CustomException;
import com.example.demo_SpringBoot.exception.ExceptionType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum JobType {
    DEVELOPER("Developer", Arrays.asList("Frontend", "Backend")),
    ENGINEER("Engineer", Arrays.asList("DevOps", "SRE"));

    String name;
    List<String> titles;

    @JsonCreator(mode = Mode.DELEGATING)
    public static JobType deserialize(String name) {
        for (JobType each : JobType.values()) {
            if (each.getName().equals(name)) {
                return each;
            }
        }
        throw new CustomException(ExceptionType.INVALID_INPUT,
            "JobType 내 해당하는 Enum이 존재하지 않습니다. name : " + name);
    }
}