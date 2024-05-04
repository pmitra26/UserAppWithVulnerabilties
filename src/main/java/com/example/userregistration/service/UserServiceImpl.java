package com.example.userregistration.service;

import com.example.userregistration.configuration.Constants;
import com.example.userregistration.model.RecoveryData;
import com.example.userregistration.model.UserDto;
import com.example.userregistration.model.UserEntity;
import com.example.userregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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

    @Override
    public void sendUserRecovery(String name, RecoveryData recoveryData) throws MalformedURLException, URISyntaxException {
       URL changePwdUrl = new URL(recoveryData.getRecoveryUrl()) ;
       String message = "<a href="+ changePwdUrl+">" + Constants.USER_PASSWORD_RECOVERY_EMAIL_HREF +"</a>";
        RestTemplate restTemplate = new RestTemplate();

        URI notificationUrl = new URI("http://laa:8080/notification");
        HttpEntity<String> request = new HttpEntity<>(message);
        ResponseEntity<String> response = restTemplate
                .exchange(notificationUrl, HttpMethod.POST, request, String.class);

        if(response.getStatusCode()!= HttpStatus.OK){
            throw new RuntimeException();
        }
    }
}
