package com.example.leetcode.test;


public class Test4 {
    public static void main(String[] args) {
    }


    /**
     * 如果两个字符串,所含字符种类完全一样，就算作一类，只有小写字母（a-z）组成的一批字符串，
     * 都放在字符串类型数组String[]arr中，返回arr中一共有多少种类。
     */
    public static int process(String[] arr) {
        return 0;
    }


    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 输入: "babad"               b ba bab baba babad
     * a ab aba abad
     * b ba bad
     * a ad
     * d
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                String s1 = str[i] + str[j] + "";
            }
        }
        return "";
    }


    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * <p>
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     * <p>
     * ab   cdefg
     * <p>
     *
     * <p>
     * 输入: s = "lrloseumgh", k = 6
     * 输出: "umghlrlose"
     */
    public static String reverseLeftWords(String s, int n) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        if (s.length() < 2 || n <= 0) {
            return s;
        }
        char[] str = s.toCharArray();
        if (n < s.length()) {
            process(str, 0, n - 1);
            process(str, n, str.length - 1);
            process(str, 0, str.length - 1);
        }
        if (n >= s.length()) {
            process(str, 0, str.length - 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            stringBuilder.append(str[i]);
        }
        return stringBuilder.toString();
    }

    public static void process(char[] str, int L, int R) {
        while (L < R) {
            char temp = str[L];
            str[L] = str[R];
            str[R] = temp;
            L++;
            R--;
        }
    }


}
