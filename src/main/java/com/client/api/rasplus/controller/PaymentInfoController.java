package com.client.api.rasplus.controller;

import com.client.api.rasplus.dto.PaymentProcessDto;
import com.client.api.rasplus.service.PaymentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentInfoController {

    private final PaymentInfoService service;

    @PostMapping
    public ResponseEntity<Boolean> process(@RequestBody PaymentProcessDto dto){
        return ResponseEntity.ok(service.process(dto));
    }
}
