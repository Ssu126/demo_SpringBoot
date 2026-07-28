package com.example.demo_SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public String userPage() {
        return "/users/list";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/users/1/detail")
    public String detailPage() {
        return "/users/detail";
    }
}
