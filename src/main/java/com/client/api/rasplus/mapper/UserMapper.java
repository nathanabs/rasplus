package com.client.api.rasplus.mapper;

import com.client.api.rasplus.dto.UserDto;
import com.client.api.rasplus.model.SubscriptionType;
import com.client.api.rasplus.model.User;
import com.client.api.rasplus.model.UserType;

public class UserMapper {

    public static User fromDtoToEntity(UserDto dto, UserType userType, SubscriptionType subscriptionType){
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .phone(dto.getPhone())
                .dateSubscription(dto.getDateSubscription())
                .dateExpiration(dto.getDateExpiration())
                .userType(userType)
                .subscriptionType(subscriptionType)
                .build();
    }

    public static User fromDtoToEntity(UserDto dto, UserType userType){
        return fromDtoToEntity(dto, userType, null);
    }
}
