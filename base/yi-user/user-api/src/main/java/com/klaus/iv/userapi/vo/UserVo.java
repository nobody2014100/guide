package com.klaus.iv.userapi.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserVo {
    private String username;
    private String openID;
    private String password;
    private String mobile;
    private String email;
    private int userType;

}
