package com.klaus.iv.appadmin.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {

    private String openID;
    private String mobile;
    private String username;
    private String password;
    private String avatar;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date birthDay;
    private List<AddressVo> addressVos = new ArrayList<>();
}
