package com.klaus.iv.leetcode;

import org.openjdk.jol.info.ClassLayout;

public class Demo {
    public static void main(String[] args) {
        ClassLayout classLayout = ClassLayout.parseInstance(new Integer(1));
        System.out.println(classLayout.toPrintable());
    }
}
