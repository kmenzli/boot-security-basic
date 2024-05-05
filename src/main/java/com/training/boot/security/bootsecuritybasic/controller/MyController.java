package com.training.boot.security.bootsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String hello() {
        return "Hello JavaInUse";
    }

    @GetMapping("/private")
    public String privateAsc() {
        return "Hello Preivate";
    }

}
