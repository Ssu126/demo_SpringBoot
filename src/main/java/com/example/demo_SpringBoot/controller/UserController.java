package com.example.demo_SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    @RequestMapping(method = RequestMethod.GET, value = "")
    public ModelAndView userPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/list");
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/1/detail")
    public ModelAndView detailPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", 1);
        modelAndView.addObject("name", "Aaron");
        modelAndView.addObject("age", 10);
        modelAndView.addObject("job", "Developer");
        modelAndView.addObject("speciality", "Backend");
        modelAndView.setViewName("/users/detail");
        return modelAndView;
    }
}
