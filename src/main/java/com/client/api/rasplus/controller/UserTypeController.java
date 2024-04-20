package com.client.api.rasplus.controller;

import com.client.api.rasplus.model.UserType;
import com.client.api.rasplus.service.UserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-type")
@RequiredArgsConstructor
public class UserTypeController {

    private final UserTypeService service;

    @GetMapping
    public ResponseEntity<List<UserType>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
