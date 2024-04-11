package com.example.userregistration.controller;

import com.example.userregistration.model.UserDto;
import com.example.userregistration.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
}
