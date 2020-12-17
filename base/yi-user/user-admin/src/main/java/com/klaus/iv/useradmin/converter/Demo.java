package com.klaus.iv.useradmin.converter;
public class Demo {

    public static void main(String[] args) {
        int i = StringToInt("+1203");
        int j = StringToInt("-123");
        int i1 = StringToInt("123a9");
        System.out.println(i);
        System.out.println(j);
        System.out.println(i1);
    }

    //陈龙 18814378692
    public static int StringToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int sum = 0;
        boolean positive = true;
        int i = 0;
        if (chars[0] == '-') {
            positive = false;
            i++;
        }
        if (chars[0] == '+') {
            i++;
        }
        for (; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return 0;
            }
            sum = sum * 10;
            sum += chars[i] - '0';
        }

        return positive ? sum : -sum;

    }
}