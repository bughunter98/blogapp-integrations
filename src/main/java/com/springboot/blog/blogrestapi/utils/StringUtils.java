package com.springboot.blog.blogrestapi.utils;

import static io.micrometer.common.util.StringUtils.isBlank;

public class StringUtils {
    public static String validateString(String inputString) {
        return isEmptyorNull(inputString) ? "" : inputString;
    }

    public static String formatString(String inputString, String deafultValue) {
        return isEmptyorNull(inputString) ? deafultValue : inputString;
    }

    public static boolean isEmptyorNull(String inputString) {
        return isBlank(inputString);
    }
}
