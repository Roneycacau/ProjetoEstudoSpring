package com.example.project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String HelloWorld() {
        return "Hello World";
    }

    @GetMapping("/simplelist")
    public String[] HelloWorldList() {
        return new String[] { "Hello", "World" };
    }

}