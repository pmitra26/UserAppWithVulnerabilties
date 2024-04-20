package com.example.userregistration.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("xss")
public class XssController {


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView indexPage(@ModelAttribute("msg") String msg, ModelAndView model) {
        if (msg != null) {
            model.addObject("msg", msg);
        }
        model.setViewName("xss/index");
        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ResponseEntity<String> indexPage2(@ModelAttribute("msg") String msg) throws Exception {
        // Set Response body
        Map<String, String> payload = new HashMap<>();
        payload.put("message", msg);

        // Set Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.TEXT_HTML_VALUE);
        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(payload), headers, HttpStatus.OK);
    }
}
