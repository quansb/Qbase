package com.example.leetcode.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author quanshibao
 * @description
 * @date 2021/5/27
 */
public class NowCoder {

    public static void main(String[] args) {

    }

    public static class Main {
        /**
         * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，
         * 不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
         * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
         * 输入描述：
         * 输入一行没有空格的字符串。
         * 输出描述：
         * 输出范围在(0~127)字符的个数。
         */
        public static void main3(String[] args) throws Exception {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String s = bf.readLine();
            boolean[] flag = new boolean[128];
            int res = 0;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (flag[c] = false) {
                    res++;
                    flag[c] = true;
                }
            }
            System.out.println(res);
        }

        /**
         * 描述
         * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
         * 保证输入的整数最后一位不是0。
         * 输入描述：
         * 输入一个int型整数
         * 输出描述：
         * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
         * 示例1
         * 输入：
         * 9876673
         * 复制
         * 输出：
         * 37689
         */
        public static void main2(String[] args) throws Exception {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String str = bf.readLine();
            int num = Integer.parseInt(str);
            byte[] flag = new byte[10];
            int res = 0;
            int temp = 0;
            while (num > 0) {
                temp = num % 10;
                num /= 10;
                if (temp == 0 && res == 0) {
                    continue;
                }
                if (flag[temp] == 0) {
                    res = res * 10 + temp;
                    flag[temp] = 1;
                }
            }
            System.out.println(res);
        }


        public static void main(String[] args) throws Exception {
            StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            st.nextToken();      // 分隔符
            int n = (int) st.nval;   // 强转
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int key = st.nextToken();

            }
            System.out.print(n);
        }
    }
}
