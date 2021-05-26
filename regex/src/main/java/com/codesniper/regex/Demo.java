package com.codesniper.regex;

import java.util.regex.Pattern;

/**
 * 正则表达式demo 每个例子涉及到不同的知识点 多加练习 字符串匹配开始用正则 之后相信会掌握它
 */
public class Demo {

    public static void main(String[] args){
         testUnitPhone();
    }

    private static void testUnitPhone(){
        System.out.println(patternPhone("17620752830"));
        System.out.println(patternPhone("17620752830X"));
        System.out.println(patternPhone("176207528301"));
        System.out.println(patternPhone("17628301"));
        System.out.println(patternPhone("27620752830"));
        System.out.println(patternPhone("12620752830"));
        System.out.println(patternPhone("13888888888"));
        System.out.println(patternPhone("136aaaaaaaa"));
    }

    /**
     * 匹配手机号
     * 特征： 11位 每一位全是0-9的数字
     *  1开头 ^1
     *  第二个字符 3 4 5 7 8 取其1  [3|4|5|7|8]
     *  后续的字符可以为0-9  [0-9]{9}
     * @param phone 手机号
     * @return 是否匹配
     */
    private static boolean patternPhone(String phone){
        String regex = "^\\d+"; //匹配多个数字
        String regex1 = "^\\d{11}"; //匹配11个数字
        String regex2 = "^1[3|4|5|7|8][0-9]{9}$"; //匹配全部规则
        return Pattern.matches(regex2,phone);
    }


}