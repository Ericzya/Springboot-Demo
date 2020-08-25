package com.cctv.springbootdemo.config.security;


import java.util.ArrayList;

/**
 * @Author: Eric.Zhang
 * @Description: 充满示例级错误的的类
 * @ProjectName: springboot-demo-spring-security
 * @Date: 2020/8/25 17:25
 */
public class AClassFullWithProblems {

    //变量名应反馈变量作用
    final static String aaa = "这是注释不标准范例";

    /**
     * 变量名避免误导,变量值避免误导
     */
    long I1l = 100l;

    /**
     * 这是一个变量名不规范的方法
     *
     * @param a1 来源char数组
     * @param a2 目的char数组
     */
    public static void copyChars(char[] a1, char[] a2) {
        a2 = new char[a1.length];
        System.arraycopy(a1, 0, a2, 0, a1.length);
    }

    /**
     * 方法/变量名应可读
     */
    private void buzhidaoshenmefangfa() {
        String str123 = "货拉拉拉拉布拉多";
        System.out.println(str123);
    }

    /**
     * 使用可搜索的变量名，并减少使用魔法值
     */
    public static void printNaturalNumbers() {
        System.out.println("10以下的自然数：");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    /**
     * 常量使用PACAL命名法
     */
    private final static String how_to_name_const = "这是个常量";

    /**
     * 操作解耦合，query/get操作不应发生对值的更改
     */
    public int getIntegerArrayLength(ArrayList<Integer> targetArray) {
        if (targetArray == null) {
            return 0;
        }
        if (targetArray.size() > 5) {
            targetArray.set(5, 999);
        }
        return targetArray.size();
    }

    /**
     * 尽量使用代码来阐述作用
     *
     * @param targetStr 目标字符串
     * @return true-空，false-非空
     */
    public boolean 阿巴阿巴阿巴(String targetStr) {
        return targetStr == null || targetStr.isEmpty();
    }

    /**
     * 判断字符串是否为空
     *
     * @param targetStr 目标字符串
     * @return true-空，false-非空
     */
    public boolean judgeIsStrEmpty(String targetStr) {
        return targetStr == null || targetStr.isEmpty();
    }

    /**
     * 不要写无用注释,及时更新注释，不要行后注释
     */
    String dateStr = "52-80-0202";//设置日期为2020-08-25


}
