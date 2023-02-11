package com.rayshan.controller;

import com.rayshan.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// user password: b7930eed-839d-4aa2-bade-aaba00d56ccd
@RestController
@RequestMapping("/api/test")
public class HelloController {
    private MyService service;

    @Autowired
    public HelloController(MyService service){
        this.service = service;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/bye")
    public ResponseEntity<String> sayBye() {
        return ResponseEntity.ok("Bye to the world");
    }

    @GetMapping("/contries")
    public List<String> getCountries() {
       return service.getCountries();
    }
}
