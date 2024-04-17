package com.example.userregistration.service;

import com.example.userregistration.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public UserDto save(UserDto department) {
        //TODO add logic
        return null;
    }

    @Override
    public List<UserDto> fetch() {
        //TODO add logic
    return List.of();
    }

    @Override
    public UserDto update(UserDto user, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        //TODO add logic
    }
}
