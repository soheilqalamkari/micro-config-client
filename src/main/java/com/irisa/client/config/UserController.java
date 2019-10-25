package com.irisa.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class UserController {


    @Value("${irisa.message:}")
    private String message;


    @GetMapping(value = "/message",produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getMessage(){
       String msg = message.toUpperCase();
       return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}