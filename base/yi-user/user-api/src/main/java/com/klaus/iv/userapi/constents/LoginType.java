package com.klaus.iv.userapi.constents;

import lombok.Getter;

@Getter
public enum LoginType {

    COMMON(1), WECHAT(2),QQ(3),MOBILE(4),EMAIL(5),GITHUB(6),ALI(7),OTHER(8);
    private int value;
    LoginType(int value) {
        this.value = value;
    }
}
