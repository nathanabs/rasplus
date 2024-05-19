package com.client.api.rasplus.mapper.client;

import com.client.api.rasplus.dto.client.CustomerDto;
import com.client.api.rasplus.model.User;

public class CustomerMapper {

    public static CustomerDto build(User user){
        var fullName = user.getName().split(" ");
        var firstName = fullName[0];
        var lastName = fullName.length > 1 ? fullName[fullName.length - 1] : "";

        return CustomerDto.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(user.getEmail())
                .cpf(user.getCpf())
                .build();
    }
}
