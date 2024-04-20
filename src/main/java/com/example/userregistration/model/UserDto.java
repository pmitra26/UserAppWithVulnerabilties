package com.example.userregistration.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;
    private String name;
    private String address;
    private String passport;
    private String password;
}
