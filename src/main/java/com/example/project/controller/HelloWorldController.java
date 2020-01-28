package com.example.project.controller;

import com.example.project.utils.SiteRoles;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorldController {
    @Secured({ SiteRoles.APP_USER })
    @GetMapping("/")
    public String HelloWorld() {
        return "Hello World";
    }

    @Secured({ SiteRoles.APP_USER })
    @GetMapping("/simplelist")
    public String[] HelloWorldList() {
        return new String[] { "Hello", "World" };
    }

}