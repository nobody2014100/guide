package com.klaus.iv.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Slf4j
public class RegexMatches {

    public static void main(String args[]) {
        String str = "这个傻子你好漂亮，特别威严";
        String pattern = "(你好|威严)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        log.info("find is: {}", m.find());
        log.info("groupCount is: {}", m.groupCount());
        log.info("toMatchResult is : {}", m.toMatchResult());
    }
}
