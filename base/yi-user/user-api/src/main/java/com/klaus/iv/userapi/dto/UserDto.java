package com.klaus.iv.userapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private Long id;
    private String username;
    private String openID;
    private String password;
    private String mobile;
    private String email;
    private int userType;

}
