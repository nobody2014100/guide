package com.klaus.iv.userapi.dto;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRolesDto extends BaseDto {
    private Long userId;
    private List<Long> roleIds;
}
