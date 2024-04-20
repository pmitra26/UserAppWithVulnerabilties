package com.example.userregistration.service;

import com.example.userregistration.model.UserDto;
import com.example.userregistration.model.UserEntity;
import com.example.userregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDto save(UserDto user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword =bCryptPasswordEncoder.encode("gbgjtkjtytjjhk");
        //TODO add logic
        UserEntity userEntity = UserEntity.builder().password(encryptedPassword).build();
        userRepository.save(userEntity);
        System.out.println("Inserted data with id: "+ user.getId());
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
