package com.example.demo_SpringBoot.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping(value = "/error", method = RequestMethod.GET)
   public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Object status =
                request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
            if (status != null) {
                Integer statusCode = Integer.valueOf(status.toString());
                if (statusCode == HttpStatus.NOT_FOUND.value()) {
                    modelAndView.addObject("status", statusCode);
                    modelAndView.addObject("reason", HttpStatus.NOT_FOUND.getReasonPhrase());
                } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                    modelAndView.addObject("status", statusCode);
                    modelAndView.addObject("reason", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
                }
            }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
