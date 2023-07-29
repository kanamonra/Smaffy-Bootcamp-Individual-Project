package com.ceceg.smaffy.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RegisterSuccessController {
    @GetMapping("/welcome")
    public List<String> welcome(){
        return Arrays.asList("Successfully registered.", "Welcome to Smaffy Demo Version");
    }
}
