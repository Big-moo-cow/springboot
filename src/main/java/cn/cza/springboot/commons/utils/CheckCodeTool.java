package cn.cza.springboot.commons.utils;import java.util.Random;/** * @Author: 车子昂 * @Date: 2019-4-25 15:01 * @Description: */public class CheckCodeTool {    //发送验证码    public static R sendCheckCode(){        R r = new R();        String sixRandom = getSixRandom();        r.put("sixRandom",sixRandom);        return r;    }    //获得一个六位的随机数字符串    public static String getSixRandom() {        String sixRandom = new String();        Random random = new Random();        for (int i = 0; i < 6; i++) {            int r = random.nextInt(10);            sixRandom += String.valueOf(r);        }        return sixRandom;    }}