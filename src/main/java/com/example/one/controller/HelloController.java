package com.example.one.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author E.habibi
 * @since 8/2/2022
 */
@RestController
public class HelloController {
    @GetMapping(value = "/helloworld")
    public ResponseEntity<String> helloWorld(@RequestParam(value = "name" , required = false) String name) {
        if (StringUtils.isNotEmpty(name)) {
            return new ResponseEntity<>("Hello "+ name, HttpStatus.OK);
        }
        return new ResponseEntity<>("Hello Stranger", HttpStatus.OK);
    }

    @GetMapping(value = "/author")
    public ResponseEntity<String> author() {
        return new ResponseEntity<>("Elaheh Habibi", HttpStatus.OK);
    }
}
