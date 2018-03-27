package com.stkj.pperty.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * 手机和邮箱基本格式效验
 * Created by yp on 2018/3/17.
 */
public class PhoneAndMailUtil {
    /**
     * 号码尾数效验，11位
     * @param phoneNumber
     * @return
     */
    public static boolean isPhoneNumber(String phoneNumber){
        phoneNumber= StringUtils.trim(phoneNumber);
        boolean bool = Pattern.matches("^[0-9]{11}$", phoneNumber);
        return bool;
    }
    /**
     * 邮箱基本格式效验
     * @param s
     * @return
     */
    public static boolean isMailAddress(String s){
        s=StringUtils.trim(s);
        boolean bool = Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\u002E[a-zA-Z0-9_-]+)+$", s);
        return bool;
    }
}
