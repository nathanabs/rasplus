package com.client.api.rasplus.service;

import com.client.api.rasplus.dto.SubscriptionTypeDto;
import com.client.api.rasplus.model.SubscriptionType;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();
    SubscriptionType findById(Long id);
    SubscriptionType create(SubscriptionTypeDto dto);
    SubscriptionType update(Long id, SubscriptionTypeDto dto);
    void delete(Long id);
}
