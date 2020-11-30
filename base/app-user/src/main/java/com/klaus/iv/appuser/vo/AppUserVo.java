package com.klaus.iv.appuser.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppUserVo {

    private String name;
    private Integer age;
    private String mobile;
}
