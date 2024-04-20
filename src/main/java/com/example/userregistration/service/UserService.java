package com.example.userregistration.service;

import com.example.userregistration.model.UserDto;
import com.example.userregistration.model.UserEntity;

import java.util.List;

public interface UserService {


    UserDto save(UserDto user);

    List<UserDto> fetch();

    UserDto update(UserDto user,
                   Long id);

    void deleteById(Long id);
}
