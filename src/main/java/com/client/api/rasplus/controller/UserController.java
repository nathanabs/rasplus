package com.client.api.rasplus.controller;

import com.client.api.rasplus.dto.UserDto;
import com.client.api.rasplus.model.User;
import com.client.api.rasplus.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserDto dto){
        return ResponseEntity.status(CREATED).body(service.create(dto));
    }
}
