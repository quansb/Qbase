package com.example.leetcode.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test {


    public static void main(String[] args) {
//        String temp = "pweek";
//        int arr[] = {1, 2, 3, 0, 1};
//        int result = findRepeatNumber2(arr);
//        System.out.println(result);
        //  System.out.println(test(10000));


        System.out.println(filterNum(123456754));
        //  filter();
    }

    public static float test(int num) {
        double temp = 0;
        if (num > 9999) {
            temp = (double) num / 10000;
        } else {
            temp = num;
        }
        BigDecimal b = new BigDecimal(String.valueOf(temp));
        BigDecimal divisor = BigDecimal.ONE;
        MathContext mc = new MathContext(5);
        BigDecimal divide = b.divide(divisor, mc);
        return divide.floatValue();
    }


    public static String filterNum(int num) {
        String content = "0";
        if (num >= 0 && num <= 10000 * 99) {
            content = String.valueOf(num);
        } else if (num >= 10000 * 100) {
            double temp = ((double) num) / 10000;
            BigDecimal b = new BigDecimal(temp);
            double result = b.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
            content = String.valueOf(result);
        }
        return content;
    }

    /**
     * @param s pweek
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    /**
     * p w e e k
     */
    public static int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int result = 0;
        int temp = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            left = i;
            //左边窗口
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }
            //右边窗口
            while (temp < length && !set.contains(s.charAt(temp))) {
                set.add(s.charAt(temp));
                right = temp;
                temp = temp + 1;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }


    /**
     * p w e e k
     * <p>
     * p w e k
     * 1 2 4
     */
    public int lengthOfLongestSubstring3(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        for (; right < s.length(); right++) {
            char temp = s.charAt(right);
            if (map.containsKey(temp)) {
                left = Math.max(map.get(temp), left);
            }
            map.put(temp, right + 1);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    /**
     * 时间复杂 O(n)  空间O(n)
     */
    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    /**
     * 1 2 3 0 1
     */
    public static int findRepeatNumber2(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }




}
