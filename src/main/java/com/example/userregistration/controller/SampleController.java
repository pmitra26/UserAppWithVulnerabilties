package com.example.userregistration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SampleController {

    @GetMapping("/")
    public String index(@RequestHeader("X-Api-Version") String apiVersion) {
        log.info("Received a request for API version {}", apiVersion);
        return "Hello, world!";
    }
}
