package com.client.api.rasplus.service.impl;

import com.client.api.rasplus.model.UserType;
import com.client.api.rasplus.repository.UserTypeRepository;
import com.client.api.rasplus.service.UserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTypeImpl implements UserTypeService {

    private final UserTypeRepository repository;

    @Override
    public List<UserType> findAll() {
        return repository.findAll();
    }
}
