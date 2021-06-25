package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class DP {

    public static void main(String[] args) {

        System.out.println(getQueen(4));

    }


    public static int getQueen(int n) {
        if (n < 1) {
            return 0;
        }
        int[] arr = new int[n];
        int res = process(0, arr, n);
        return res;
    }


    /**
     * 0  1  2  3  4
     * 0 *
     * 1       *
     * 2             *
     * 3    *
     * 4          *
     */
    public static int process(int i, int[] arr, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < arr.length; j++) {
            if (isRightQueen(i, j, arr)) {
                arr[i] = j;
                res = res + process(i + 1, arr, n);
            }
        }
        return res;
    }

    public static boolean isRightQueen(int i, int j, int[] arr) {
        for (int k = 0; k < i; k++) {
            if (arr[k] == j) {
                return false;
            }
            if (Math.abs(i - k) == Math.abs(arr[k] - j)) {
                return false;
            }
        }
        return true;
    }


    public static Info process2(int i, int[] arr, int n) {
        if (i == n) {
            Info info = new Info();
            info.num = 1;
            info.result.add(saveWay(n, arr));
            return info;
        }
        Info info = new Info();
        for (int j = 0; j < arr.length; j++) {
            if (isRightQueen(i, j, arr)) {
                arr[i] = j;
                Info info1 = process2(i + 1, arr, n);
                info.num = info.num + info1.num;
                info.result.addAll(info1.result);
            }
        }
        return info;
    }

    private static List<String> saveWay(int n, int[] arr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (arr[i] == j) {
                    builder.append("Q");
                } else {
                    builder.append("");
                }
            }
            list.add(builder.toString());
        }
        return list;
    }

    public static class Info {
        private int num;
        private List<List<String>> result = new ArrayList<>();
    }


    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<List<String>>();
        }
        int[] arr = new int[n];
        Info info = process2(0, arr, n);
        return info.result;
    }






}
