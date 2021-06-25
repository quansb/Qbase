package com.example.leetcode.data;

/**
 * @author quanshibao
 * @description
 * @date 2021/3/9
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        // System.out.println(zj.stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
    }


    public int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); i++) {
            res = Math.max(res, n.charAt(i) - '0');
        }
        return res;
    }

    /**
     * 输入：stones = [7,90,5,1,100,10,10,2]
     * 输出：122
     */
    public int stoneGameVII(int[] stones) {
        int res = 0;
        for (int stone : stones) {
            res += stone;
        }
        Integer[][] dp = new Integer[stones.length][stones.length];
        return dp(0, stones.length - 1, stones, res, dp);
    }

    public int dp(int left, int right, int[] arr, int sum, Integer[][] dp) {
        if (left == right) {
            return 0;
        }
        if (dp[left][right] != null) {
            return dp[left][right];
        }
        int a = sum - arr[left] - dp(left + 1, right, arr, sum - arr[left], dp);
        int b = sum - arr[right] - dp(left, right - 1, arr, sum - arr[right], dp);
        return dp[left][right] = Math.max(a, b);
    }

    /**
     * 暴力匹配是否是子串
     */
    private static boolean matchString(String s, String match) {
        int i = 0;
        int j = 0;
        int start = 0;
        while (i < s.length() && j < match.length()) {
            System.out.println(s.charAt(i) + " " + match.charAt(j));
            if (s.charAt(i) == match.charAt(j)) {
                i++;
                j++;
            } else {
                start += 1;
                i = start;
                j = 0;
            }
        }
        return j == match.length();
    }

    /**
     * 获取所有数字的下标
     */
    public static int[][] getNumberIndex2(String content) {
        int[][] res = {{-1, -1}};
        int index = 0;
        if (!(content == null || content.length() == 0)) {
            for (int i = content.length() - 1; i >= 0; i--) {
                char c = content.charAt(i);
                if ((c >= '0' && c <= '9')) {
                    index = i;
                    res[0][1] = index;
                    break;
                }
            }
            for (int i = index; i >= 0; i--) {
                char c = content.charAt(i);
                if ((c >= '0' && c <= '9')) {
                    res[0][0] = i;
                } else {
                    break;
                }
            }
        }
        return res;
    }


}
