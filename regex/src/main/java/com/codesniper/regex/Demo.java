package com.codesniper.regex;

import java.util.regex.Pattern;

/**
 * 正则表达式demo 每个例子涉及到不同的知识点 多加练习 字符串匹配开始用正则(实践) 之后相信会掌握它
 */
public class Demo {

    public static void main(String[] args){
//         testUnitPhone();
        testUnitHttp();
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

    private static void testUnitHttp(){
        System.out.println(patternHttpUrl("http://"));
        System.out.println(patternHttpUrl("https://"));
        System.out.println(patternHttpUrl("https://mo."));
        System.out.println(patternHttpUrl("https://mo.gov-alibaba."));
        System.out.println(patternHttpUrl("https://mo.gov-alibaba.com"));
        System.out.println(patternHttpUrl("https://mo.gov-alibaba.cn"));
        System.out.println(patternHttpUrl("https://mo.gov-alibaba.cn/"));
        System.out.println(patternHttpUrl("https://mo.gov-alibaba.cn?"));
        System.out.println(patternHttpUrl("https://mo.gov-alibaba.cn/aaa=bbb&ccc=ddd&eee=%2F"));
        System.out.println(patternHttpUrl("https://mo.gov-alibaba.cn?aaa=bbb&ccc=ddd&eee=%2F/bbbbb"));
        System.out.println(patternHttpUrl("https://error.taobao.com/app/tbhome/common/error.html"));
        System.out.println(patternHttpUrl("https://error.taobao.com/app/tbhome/common/error.html?c=404"));
        System.out.println(patternHttpUrl("https://error.taobao.com/app/tbhome/common/error.html?c=404&u=http://dataweek.alibaba-inc.com"));
        System.out.println(patternHttpUrl("https://error.taobao.com/app/tbhome/common/error.html?c=404&u=http://dataweek.alibaba-inc.com/&r=https://www.baidu.com/link?url=F_Dlgbrp8dHEjBHOx-xQAyWxJD2wOqSlkmX9GR5oixRB5vtw5XSrbOqn_pHiSEqw&wd=&eqid=98dbab22000ae1f70000000660ae6a4d"));
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

    /**
     * 匹配HTTP协议的url
     * 特征 http或https开头
     *  ://中间
     *  host www.baidu.com mo.commonservice.go www.alibaba-inc.com
     *  java需要多加一个\
     *  ()+ 匹配括号里面多次或一次
     *  \\w 匹配任何字符
     *  - 匹配减号
     *  [\\w-]+ 匹配任何字符和减号的任何一个 多次或一次
     *  \\. 匹配点号
     *  ([\\w-]+\.)+   可以匹配 xxx.xx.xx-xx.
     *  [\\w-]+  表示匹配 xxx.xxx.xx-xx.xx
     *  可以是多个任何字类字符或者减号 ([\w-]+\.)+  匹配 www.alibaba-inc.
     *  com 或者 cn  [\w-]+
     *  /xxx/xxx/xxx ?aaa=bbb&ccc=ddd&eee=%2Fw
     *   query后面的符号   [\w-./?%&=]* 匹配多个字符
     *   (/[\w-./?%&=]*)?匹配0次或1次
     *
     *   (/)?表示后面可以为空 也可以是里面的一个匹配规则/
     *   [\w-./?%&=]*  这些字符选其1 零次或多次匹配 也就是多个字符 ?aaa=bbb&ccc=ddd
     *
     * @param url
     * @return
     */
    private static boolean patternHttpUrl(String url){
        String regex = "^http(s)?://";
        String regex2 = "^http(s)?://([\\w-]+\\.)+";
        String regex3 = "^http(s)?://([\\w-]+\\.)+[\\w-]+";
        String regex4 = "^http(s)?://([\\w-]+\\.)+[\\w-]+\\?[\\w-./?%&=]*$";
        String regex5 = "^http(s)?://([\\w-]+\\.)+[\\w-]+([/\\?][\\w-./?%&=/:]*)?$";
        //        ?aaa=bbb  0次或者1次
        return Pattern.matches(regex5,url);
    }


    private static boolean patternMogovScheme(){
        return false;
    }


}