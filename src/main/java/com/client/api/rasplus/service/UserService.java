package com.client.api.rasplus.service;

import com.client.api.rasplus.dto.UserDto;
import com.client.api.rasplus.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
    User create(UserDto dto);
    User update(Long id, UserDto dto);
    void delete(Long id);
}
