package com.client.api.rasplus.service.impl;

import com.client.api.rasplus.dto.SubscriptionTypeDto;
import com.client.api.rasplus.exception.NotFoundException;
import com.client.api.rasplus.mapper.SubscriptionTypeMapper;
import com.client.api.rasplus.model.SubscriptionType;
import com.client.api.rasplus.repository.SubscriptionTypeRepository;
import com.client.api.rasplus.service.SubscriptionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository repository;


    @Override
    public List<SubscriptionType> findAll() {
        return repository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        return getSubscriptionType(id);
    }

    private SubscriptionType getSubscriptionType(Long id) {
        var subscriptionOptional = repository.findById(id);

        if (subscriptionOptional.isEmpty()){
            throw new NotFoundException("SubscriptionType not found");
        }
        return subscriptionOptional.get();
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDto dto) {
        var subscriptionType = SubscriptionTypeMapper.fromDtoToEntity(dto);
        return repository.save(subscriptionType);
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDto dto) {
        getSubscriptionType(id);

        var subscriptionType = SubscriptionTypeMapper.fromDtoToEntity(dto);
        subscriptionType.setId(id);
        return repository.save(subscriptionType);
    }

    @Override
    public void delete(Long id) {
        var subscriptionType = getSubscriptionType(id);
        repository.delete(subscriptionType);
    }
}
