package com.josdem.springboot.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MessageController {

    @GetMapping("/message")
    public String message() {
        log.info("Calling private message");
        return "message";
    }
}
