package com.client.api.rasplus.controller;

import com.client.api.rasplus.dto.SubscriptionTypeDto;
import com.client.api.rasplus.model.SubscriptionType;
import com.client.api.rasplus.service.SubscriptionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription-type")
@RequiredArgsConstructor
public class SubscriptionTypeController {

    private final SubscriptionTypeService service;

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable("id") Long id){
        var subscriptionType = service.findById(id);

        return ResponseEntity.ok(subscriptionType);
    }

    @PostMapping
    public ResponseEntity<SubscriptionType> save(@RequestBody SubscriptionTypeDto dto){


        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionType> Update(@PathVariable("id") Long id, @RequestBody SubscriptionTypeDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubscriptionType> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
