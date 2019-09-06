package com.wankang.demo.service.LeeCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author wankang
 * @create 2019-09-06 11:49
 **/
public class LeeCodeTest03 {

    public static void main(String... args){
        int num = lengthOfLongestSubstring("cbb");
        System.out.println(num);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxNum = 1;
        for (int i = 0; i < chars.length; i++) {
            int num = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    break;
                }
                num++;
                // 字串必须无重复字符
                if (num > maxNum && judgeUnique(s,i,i+num)) {
                    maxNum = num;
                }
            }

        }

        return maxNum;
    }

    // 判断字符串中是否含有重复值
    public static  boolean judgeUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i< end; i++){
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }




    

}
