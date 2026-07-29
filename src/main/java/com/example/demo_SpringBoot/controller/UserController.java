package com.example.demo_SpringBoot.controller;

import com.example.demo_SpringBoot.service.User;
import com.example.demo_SpringBoot.service.UserService;
import com.example.demo_SpringBoot.service.UserServiceInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {
    UserServiceInterface userService;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/bean")
    @ResponseBody
    public String bean() {
        return applicationContext.getBean(UserServiceInterface.class).toString();
    }

    @GetMapping("")
    public String userPage(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "/users/list";
    }

    @GetMapping("/{id}/detail")
    public String detailPage(@PathVariable Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("id", user.getId());
        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());
        model.addAttribute("job", user.getJob());
        model.addAttribute("speciality", user.getSpecialty());
        return "/users/detail";
    }

    @GetMapping("/{id}/data")
    @ResponseBody
    public User detailData(@PathVariable Integer id) {
        User user = userService.findById(id);
        return user;
    }
}
