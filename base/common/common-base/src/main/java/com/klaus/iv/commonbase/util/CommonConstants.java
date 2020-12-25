package com.klaus.iv.commonbase.util;

public class CommonConstants {
    /**
     * pattern    project:env:module:key
     */
    public final static String REDIS_PREFIX = "%s:%s";

    private CommonConstants() {
    }

    public enum DeleteSet {
        DELETED('Y'),
        UNDELETED('N');
        private char value;

        public void setValue(char value) {
            this.value = value;
        }

        public char getValue() {
            return this.value;
        }

        DeleteSet(char value) {
            this.value = value;
        }
    }

    public enum GenderSet {
        FEMAIL('F'),
        MAIL('M'),
        PRIVATE('N');
        private char value;

        public void setValue(char value) {
            this.value = value;
        }

        public char getValue() {
            return this.value;
        }

        GenderSet(char value) {
            this.value = value;
        }
    }



    public enum DataPattern {
        YYYY("yyyy"),
        YYYY_MM_DD("yyyy-MM-dd"),
        YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd hh:mm:ss"),
        YYYYMMDD("yyyyMMdd"),
        YYYYMMDDHH("yyyyMMddhh"),
        YYYYMMDDHHMM("yyyyMMddhhmm"),
        YYYYMMDDHHMMSS("yyyyMMddhhmmss");
        private String  value;

        public void setValue(String  value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        DataPattern(String  value) {
            this.value = value;
        }
    }

}
