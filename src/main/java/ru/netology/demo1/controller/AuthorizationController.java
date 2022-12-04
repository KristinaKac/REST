package ru.netology.demo1.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.demo1.service.AuthorizationService;
import ru.netology.demo1.model.Authorities;
import ru.netology.demo1.model.User;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service){
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @PostMapping("/authorize")
    public List<User> postAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.postAuthorities(user, password);
    }
}
