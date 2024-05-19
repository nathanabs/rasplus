package com.client.api.rasplus.service;

import com.client.api.rasplus.dto.PaymentProcessDto;

public interface PaymentInfoService {

    Boolean process(PaymentProcessDto dto);
}
