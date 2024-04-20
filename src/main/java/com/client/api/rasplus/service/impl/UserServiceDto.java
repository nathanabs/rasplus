package com.client.api.rasplus.service.impl;

import com.client.api.rasplus.dto.UserDto;
import com.client.api.rasplus.exception.NotFoundException;
import com.client.api.rasplus.mapper.UserMapper;
import com.client.api.rasplus.model.User;
import com.client.api.rasplus.repository.UserRepository;
import com.client.api.rasplus.repository.UserTypeRepository;
import com.client.api.rasplus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceDto implements UserService {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User create(UserDto dto) {

        var userTypeOpt = userTypeRepository.findById(dto.getUserTypeId());
        if (userTypeOpt.isEmpty()){
            throw new NotFoundException("User type not found");
        }

        var userType = userTypeOpt.get();
        var user = UserMapper.fromDtoToEntity(dto, userType);

        return userRepository.save(user);
    }

    @Override
    public User update(Long id, UserDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
