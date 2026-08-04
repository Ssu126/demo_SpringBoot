package com.example.demo_SpringBoot.service;

import com.example.demo_SpringBoot.controller.dto.JobType;
import com.example.demo_SpringBoot.controller.dto.UserResponseDto;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto findById(Integer id) {
        User user = userRepository.findById(id);
        return UserResponseDto.from(user);
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
            .stream()
            .map(UserResponseDto::from)
            .toList();
    }

    public UserResponseDto save(String name, Integer age, JobType job, String specialty) {
        User user = userRepository.save(
            new User(null, name, age, job, specialty, LocalDateTime.now()));
        return UserResponseDto.from(user);
    }
}
