package com.example.userregistration.controller;

import com.example.userregistration.service.LinkLister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.LinkException;
import java.io.IOException;
import java.util.List;


@RestController
@EnableAutoConfiguration
public class LinksController {
  @Autowired
  LinkLister linkLister;
  @RequestMapping(value = "/links", produces = "application/json")
  List<String> links(@RequestParam String url) throws IOException{
    return linkLister.getLinks(url);
  }
  @RequestMapping(value = "/links-v2", produces = "application/json")
  List<String> linksV2(@RequestParam String url) throws LinkException {
    return linkLister.getLinksV2(url);
  }
}
