package com.example.userregistration.controller;

import com.example.userregistration.model.RecoveryData;
import com.example.userregistration.model.UserDto;
import com.example.userregistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public UserDto saveUserDto(
            @Valid @RequestBody UserDto user) {


        return userService.save(user);
    }

    @GetMapping("/users")
    public List<UserDto> fetchUserDtoList() {
        return userService.fetch();
    }


    @PutMapping("/users/{id}")
    public UserDto
    updateUserDto(@RequestBody UserDto userDto,
                  @PathVariable("id") Long id) {
        return userService.update(
                userDto, id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserDtoById(@PathVariable("id")
                                    Long id) {
        userService.deleteById(
                id);

        return "Deleted Successfully";
    }


    @PostMapping("/users/{name}/forgotPwd")
    public ResponseEntity<String> sendUserResetPwd( @PathVariable("name") String name,
            @Valid @RequestBody RecoveryData recoveryData) throws MalformedURLException, URISyntaxException {
         userService.sendUserRecovery(name,recoveryData);
         return new ResponseEntity<>( "Success", HttpStatus.OK);
    }
}
