package com.example.userregistration.service;

import com.example.userregistration.model.RecoveryData;
import com.example.userregistration.model.UserDto;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

public interface UserService {


    UserDto save(UserDto user);

    List<UserDto> fetch();

    UserDto update(UserDto user,
                   Long id);

    void deleteById(Long id);

    void sendUserRecovery(String name, RecoveryData recoveryData) throws MalformedURLException, URISyntaxException;
}
