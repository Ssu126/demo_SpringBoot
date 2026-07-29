package com.example.demo_SpringBoot.controller;

import com.example.demo_SpringBoot.service.User;
import com.example.demo_SpringBoot.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceInterface AUserService;

    @GetMapping("")
    public String userPage(Model model) {
        List<User> users = AUserService.findAll();
        model.addAttribute("users", users);
        return "/users/list";
    }

    @GetMapping("/1/detail")
    public String detailPage(Model model) {
        User user = AUserService.findById(1);
        model.addAttribute("id", user.getId());
        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());
        model.addAttribute("job", user.getJob());
        model.addAttribute("speciality", user.getSpecialty());
        return "/users/detail";
    }

    @GetMapping
    @ResponseBody
    public User detailData() {
        User user = AUserService.findById(1);
        return user;
    }
}
