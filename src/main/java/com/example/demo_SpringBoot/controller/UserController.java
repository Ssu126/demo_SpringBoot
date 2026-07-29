package com.example.demo_SpringBoot.controller;

import com.example.demo_SpringBoot.service.User;
import com.example.demo_SpringBoot.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private List<UserServiceInterface> userService;

    @GetMapping("")
    public ModelAndView userPage() {
        ModelAndView modelAndView = new ModelAndView();
        userService.forEach((each) -> {
            System.out.println(each.getClass().getSimpleName());
        });
        UserServiceInterface AUserService = userService.get(0);
        List<User> users = AUserService.findAll();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("/user/list");
        return modelAndView;
    }

    @GetMapping("/1/detail")
    public ModelAndView detailPage() {
        ModelAndView modelAndView = new ModelAndView();
        userService.forEach((each) -> {
            System.out.println(each.getClass().getSimpleName());
        });
        UserServiceInterface AUserService = userService.get(0);
        User user = AUserService.findById(1);
        modelAndView.addObject("id", user.getId());
        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("age", user.getAge());
        modelAndView.addObject("job", user.getJob());
        modelAndView.addObject("speciality", user.getSpecialty());
        modelAndView.setViewName("/users/detail");
        return modelAndView;
    }
}
