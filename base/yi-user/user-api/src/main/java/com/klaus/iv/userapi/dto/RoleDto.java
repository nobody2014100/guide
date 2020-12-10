package com.klaus.iv.userapi.dto;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleDto extends BaseDto {

    private String name;
    private String code;

}
