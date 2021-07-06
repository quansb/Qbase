package com.example.leetcode.data;

import com.example.leetcode.base.DataFactory;
import com.example.leetcode.base.tree.Node;
import com.example.leetcode.test.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

/**
 * @author quanshibao
 * @description
 * @date 2021/2/22
 */
public class Offer {

    public static void main(String[] args) {
        Offer offer = new Offer();
//        Object[] arr = {3, 9, 20, null, null, 15, 7};
//        TreeNode head = DataFactory.createTree(arr, 0, arr.length);
//        System.out.println(test.levelOrder2(head));
//        System.out.println(test.levelOrderZ(head));
//        System.out.println(test.verifyPostorder(TreeDataFactory.arr1));
//        TreeNode tree = DataFactory.createTree(TreeDataFactory.arr5);
//        DataFactory.printTree(tree);
//        System.out.println(test.pathSum(tree, 22));
//        System.out.println(test.maxSubArray(TreeDataFactory.arr7));
//        System.out.println(test.maxSubArray2(TreeDataFactory.arr6));
//        System.out.println(test.maxSubArray3(TreeDataFactory.arr6));
//        Node node = DataFactory.createNode(new Object[]{4, 2, 5, 1, 3, null, null});
//        DataFactory.printTree(node);
//        Node node1 = test.treeToDoublyList(node);
//        System.out.println(node1.val);
//        TreeNode node = DataFactory.createTreeNode(new Object[]{1, 2, 3, null, null, 4, 5});
//        TreeNode node = DataFactory.createTreeNode(new Object[]{5, 2, 3, null, null
//                , 2, 4, null, null, null, null, 3, 1, null, null});
//        DataFactory.printTree(node);
//        Codec3 codec = new Codec3();
//        String serialize = codec.serialize(node);
//        System.out.println(serialize);
//        TreeNode deserialize = codec.deserialize(serialize);
//        DataFactory.printTree(deserialize);

        //      System.out.println(test.majorityElement2(TreeDataFactory.arr8));
        //     System.out.println(test.getLeastNumbers(TreeDataFactory.arr8,3));
        //  DataFactory.printArr(test.getLeastNumbers(TreeDataFactory.arr9, 3));
        //  System.out.println(test.minNumber(TreeDataFactory.arr13));
        //    System.out.println(test.translateNum(506));
        //     System.out.println(test.translateNum2(12258));
        //    System.out.println(test.maxValue(TreeDataFactory.offer47));
        //    System.out.println(test.maxValue2(TreeDataFactory.offer47));
        //  System.out.println(test.lengthOfLongestSubstring("pwwkew"));
        //  System.out.println(test.firstUniqChar("abaccdeff"));
        //       System.out.println(test.search(TreeDataFactory.offer53, 8));
//        System.out.println(test.getFirstK(TreeDataFactory.offer53, 8, 0, 5));
//        System.out.println(test.getLastK(TreeDataFactory.offer53, 8, 0, 5));
//        System.out.println(test.missingNumber(TreeDataFactory.offer53_2));
//        System.out.println(test.missingNumber(new int[]{1, 2, 3}));
        //       System.out.println(test.missingNumber(TreeDataFactory.offer53_2));
//        System.out.println(test.singleNumbers(TreeDataFactory.offer56)[1]);
//        System.out.println(test.singleNumber(TreeDataFactory.offer56));
//        System.out.println(test.singleNumber(TreeDataFactory.offer56_2));

//        System.out.println(test.twoSum(TreeDataFactory.offer57, 9)[1]);
        //       System.out.println(test.twoSum2(TreeDataFactory.offer57_2, 40)[0]);
        //       System.out.println(test.findContinuousSequence(9)[0][1]);
        //   System.out.println(test.reverseWords("  hello world!  "));
//        System.out.println(test.reverseWords("the sky is blue"));
//        System.out.println(test.reverseWords2("the sky is blue"));
//        System.out.println(test.reverseWords2("example   good a"));
//        System.out.println(test.reverseWords3("  hello world!  "));
//        System.out.println(test.maxSlidingWindow(TreeDataFactory.offer59_2, 1));
//        System.out.println(test.isStraight(TreeDataFactory.offer61));
//        System.out.println(test.isStraight(TreeDataFactory.offer61_2));
//        System.out.println(test.isStraight2(TreeDataFactory.offer61_2));
//        System.out.println(test.isStraight2(TreeDataFactory.offer61_2));
//        System.out.println(test.maxProfit(TreeDataFactory.offer63));
//        System.out.println(test.maxProfit(TreeDataFactory.offer63_2));
        System.out.println(offer.lowestCommonAncestor2(DataFactory.createTreeNode(new Object[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(1)).val);
        System.out.println(offer.lowestCommonAncestor3(DataFactory.createTreeNode(new Object[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(1)).val);
    }

    public static int movingCount(int m, int n, int k) {
        if (m < 0 || n < 0 || k < 0) {
            return 0;
        }
        boolean[][] arr = new boolean[m][n];
        return process(k, m, n, 0, 0, arr);
    }

    private static int process(int threshold, int rows, int cols, int row, int col, boolean[][] arr) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, arr)) {
            arr[row][col] = true;
            count = 1
                    + process(threshold, rows, cols, row + 1, col, arr)
                    + process(threshold, rows, cols, row, col + 1, arr);
        }
        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] arr) {
        return row >= 0
                && col >= 0
                && row < rows
                && col < cols
                && !arr[row][col]
                && checkSum(row) + checkSum(col) <= threshold;
    }

    private static int checkSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int colLeft = 0;
            int colRight = matrix[0].length - 1;
            while (colLeft <= colRight) {
                int mid2 = (colLeft + colRight) >> 1;
                if (target == matrix[i][mid2]) {
                    return true;
                } else if (target < matrix[i][mid2]) {
                    colRight = mid2 - 1;
                } else if (target > matrix[i][mid2]) {
                    colLeft = mid2 + 1;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            int num = matrix[row][col];
            if (target == num) {
                return true;
            }
            if (target < num) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }


    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1; // 注意
            }
        }
        return -1;
    }

    private static int average(int num1, int num2) {
        return (num1 + num2) >> 1;
    }


    public String replaceSpace(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                sum++;
            }
        }
        char[] res = new char[sum * 3 + chars.length - sum];
        int resIndex = res.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                res[resIndex--] = '0';
                res[resIndex--] = '2';
                res[resIndex--] = '%';
            } else {
                res[resIndex--] = chars[i];
            }
        }
        return new String(res, 0, res.length);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

    public int[] reversePrint2(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int[] res = new int[size];
        ListNode temp2 = head;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = temp2.val;
            temp2 = temp2.next;
        }
        return res;
    }

    public int[] reversePrint3(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int[] res = new int[size];
        reversePrint3(head, res);
        return res;
    }

    public int reversePrint3(ListNode head, int[] res) {
        if (head == null) {
            return 0;
        }
        int i = reversePrint3(head.next, res);
        if (i >= 0) {
            res[i] = head.val;
        }
        return i + 1;
    }

    /**
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 3 9 20 15 7
     * 9 3 15 20 7
     * <p>
     * 3
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
    }


    public TreeNode build(int[] preArr, Map<Integer, Integer> map, int preLeft, int preRight, int inorderLeft, int inorderRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preArr[preLeft]);
        int inorder_root_index = map.get(preArr[preLeft]);
        int leftChildSize = inorder_root_index - inorderLeft;
        rootNode.left = build(preArr, map, preLeft + 1, preLeft + leftChildSize, inorderLeft, inorder_root_index);
        rootNode.right = build(preArr, map, preLeft + leftChildSize + 1, preRight, inorder_root_index + 1, inorderRight);
        return rootNode;
    }


    public String mergeAlternately(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        char[] chars = new char[length1 + length2];
        int index = 0;
        if (length1 > length2) {
            for (int i = 0; i < chars1.length; i++) {
                chars[index++] = chars1[i];
                if (i < chars2.length) {
                    chars[index++] = chars2[i];
                }
            }
        } else {
            for (int i = 0; i < chars2.length; i++) {
                if (i < chars1.length) {
                    chars[index++] = chars1[i];
                }
                chars[index++] = chars2[i];
            }
        }
        return new String(chars);
    }

    public static class CQueue {
        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.size() == 0) {
                while (stack1.size() != 0) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.size() == 0) {
                return -1;
            }
            return stack2.pop();
        }
    }


    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] > 1000000007) {
                arr[i - 1] %= 1000000007;
            }
            if (arr[i - 2] > 1000000007) {
                arr[i - 2] %= 1000000007;
            }
            arr[i] = arr[i - 1] + arr[i - 2];
            if (arr[i] > 1000000007) {
                arr[i] %= 1000000007;
            }
        }
        return arr[n];
    }


    public static int fib2(int n) {
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 0; i < n + 1; i++) {
            a = b;
            b = c;
            c = (a + b) % 1000000007;
        }
        return a;
    }

    /**
     * [3,4,5,0,1,2]
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }


    /**
     * [["C","A","A"],
     * ["A","A","A"],
     * ["B","C","D"]]
     * "AAB"
     */
    private int path;

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] flag = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (search(board, word, 0, flag, rows, cols, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int path, boolean[][] flag, int rows, int cols, int row, int col) {
        if (row >= 0 && row < rows
                && col >= 0
                && col < cols
                && !flag[row][col]
                && board[row][col] == word.charAt(path)) {
            if (path == word.length() - 1) {
                return true;
            }
            flag[row][col] = true;
            if (search(board, word, path + 1, flag, rows, cols, row + 1, col)
                    || search(board, word, path + 1, flag, rows, cols, row - 1, col)
                    || search(board, word, path + 1, flag, rows, cols, row, col + 1)
                    || search(board, word, path + 1, flag, rows, cols, row, col - 1)) {
                return true;
            }
            flag[row][col] = false;
            return false;
        }
        return false;
    }


    public boolean exist2(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (search2(board, word, 0, rows, cols, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search2(char[][] board, String word, int path, int rows, int cols, int row, int col) {
        if (row >= 0 && row < rows
                && col >= 0
                && col < cols
                && board[row][col] == word.charAt(path)) {
            if (path == word.length() - 1) {
                return true;
            }
            board[row][col] = '\0';
            if (row == 0) {
                if (search2(board, word, path + 1, rows, cols, row + 1, col)
                        || search2(board, word, path + 1, rows, cols, row, col + 1)
                        || search2(board, word, path + 1, rows, cols, row, col - 1)) {
                    return true;
                }
            } else if (row == rows - 1) {
                if (search2(board, word, path + 1, rows, cols, row - 1, col)
                        || search2(board, word, path + 1, rows, cols, row, col + 1)
                        || search2(board, word, path + 1, rows, cols, row, col - 1)) {
                    return true;
                }
            } else if (col == 0) {
                if (search2(board, word, path + 1, rows, cols, row + 1, col)
                        || search2(board, word, path + 1, rows, cols, row - 1, col)
                        || search2(board, word, path + 1, rows, cols, row, col + 1)) {
                    return true;
                }
            } else if (col == cols - 1) {
                if (search2(board, word, path + 1, rows, cols, row + 1, col)
                        || search2(board, word, path + 1, rows, cols, row - 1, col)
                        || search2(board, word, path + 1, rows, cols, row, col - 1)) {
                    return true;
                }
            } else {
                if (search2(board, word, path + 1, rows, cols, row - 1, col)
                        || search2(board, word, path + 1, rows, cols, row + 1, col)
                        || search2(board, word, path + 1, rows, cols, row, col + 1)
                        || search2(board, word, path + 1, rows, cols, row, col - 1)) {
                    return true;
                }
            }
            board[row][col] = word.charAt(path);
            return false;
        }
        return false;
    }


    /**
     * 给你一根长度为 n 的绳子，
     * 请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
     * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * <p>
     * 示例 1：
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * <p>
     * 示例 2:
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * f(5)
     * <p>
     * 1*4,1*f(4)  2*3,2*f(3)      3*2,3*f(2)     4*1,4*f(1)
     * 4,1*(1*3,1*f(3)   2*2,2*f(2)   3*1,3*f(1) )    6,2*
     */
    public static int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        int res = -1;
        for (int i = 1; i < n; i++) {
            int max = Math.max(i * (n - i), i * cuttingRope(n - i));
            res = Math.max(res, max);
        }
        return res;
    }

    public static int cuttingRope2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        int res;
        for (int i = 4; i < dp.length; i++) {
            res = 0;
            for (int j = 1; j < i; j++) {
                int num1 = (i - j) * j;
                int num2 = j * dp[i - j];
                int temp = Math.max(num1, num2);
                res = Math.max(res, temp);
            }
            dp[i] = res;
        }
        return dp[n];
    }


    // you need to treat n as an unsigned value

    /**
     * 1100     n
     * 1011    n-1
     * <p>
     * 111111111111111111111111111111010
     * 111111111111111111111111111111001
     * 11111111111111111111111111111100
     */
    public static int hammingWeight(int n) {
        int res = 0;
        int temp = n;
        while (temp != 0) {
            temp = (temp - 1) & temp;
            res++;
        }
        return res;
    }

    public static int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }


    /**
     * 实现函数double Power(double base, int exponent)，
     * 求base的exponent次方。
     * 不得使用库函数，同时不需要考虑大数问题。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        return n > 0 ? unsigned2(x, n) : 1 / unsigned2(x, -(long) n);
    }

    public static double unsigned(double base, long n) {
        if (n == 0) {
            return 1.0;
        }
        double res = unsigned(base, n >> 1);
        return ((n & 1) == 0) ? res * res : res * res * base;
    }

    public static double unsigned2(double base, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        double res = unsigned2(base, n >> 1);
        res *= res;
        if ((n & 1) == 1) {
            res *= base;
        }
        return res;
    }


    public static double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / x * myPow2(1 / x, -n - 1);
        }
        return ((n & 1) == 0) ? myPow2(x * x, n >> 1) : x * myPow2(x * x, n >> 1);
    }

    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
     * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * <p>
     * 示例 1:
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     *  
     * 说明：
     * 用返回一个整数列表来代替打印
     * n 为正整数
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] res = new int[max - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    private static int resIndex;

    public static int[] printNumbers2(int n) {
        if (n < 0) {
            return new int[0];
        }
        int max = (int) Math.pow(10, n);
        int[] res = new int[max - 1];
        StringBuilder stringBuilder = new StringBuilder();
        dfsNumber(n, 0, stringBuilder, res);
        return res;
    }

    public static void dfsNumber(int n, int index, StringBuilder builder, int[] res) {
        if (index == n) {
            while (builder.length() != 0 && builder.charAt(0) == '0') {
                builder.deleteCharAt(0);
            }
            if (builder.length() != 0) {
                res[resIndex++] = Integer.parseInt(builder.toString());
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            builder.append(i);
            dfsNumber(n, index + 1, builder, res);
            if (builder.length() != 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }


    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * 注意：此题对比原题有改动
     * 示例 1:
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            ListNode next = head.next;
            head.next = null;
            return next;
        }
        ListNode temp = head;
        ListNode first = head;
        while (temp != null) {
            if (temp.val == val) {
                first.next = temp.next;
                temp.next = null;
            }
            first = temp;
            temp = temp.next;
        }
        return head;
    }


    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode temp = head;
        while (temp.next != null && temp.next.val != val) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }

    public ListNode deleteNode3(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return head;
        }
        if (head == node) {
            ListNode next = head.next;
            head.next = null;
            return next;
        }

        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }

        return head;
    }


    /**
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，
     * 字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        return isMatch(sChar, pChar, 0, 0);
    }


    /**
     * aaa
     * ab*ac*a
     */
    public static boolean isMatch(char[] str, char[] pattern, int strIndex, int patternIndex) {
        if (strIndex >= str.length && patternIndex >= pattern.length) {
            return true;
        }
        if (strIndex == str.length && patternIndex < pattern.length) {
            return true;
        }
        if (patternIndex == pattern.length && strIndex < str.length) {
            return false;
        }
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.' && strIndex < str.length)) {
                return isMatch(str, pattern, strIndex + 1, patternIndex + 2)
                        || isMatch(str, pattern, strIndex + 1, patternIndex)
                        || isMatch(str, pattern, strIndex, patternIndex + 2);
            } else {
                return isMatch(str, pattern, strIndex, patternIndex + 2);
            }
        }
        if (str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.' && strIndex < str.length)) {
            return isMatch(str, pattern, strIndex + 1, patternIndex + 1);
        }
        return false;
    }


    /**
     * Offer 22. 链表中倒数第k个节点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i < k; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (k > 0) {
                k--;
            } else {
                slow = slow.next;
            }
        }
        return slow;
    }


    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * <p>
     * 示例1：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 限制：
     * <p>
     * 0 <= 链表长度 <= 1000
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode fist = l1;
        ListNode second = l2;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (fist != null || second != null) {
            if (fist == null) {
                temp.next = second;
                return head.next;
            }
            if (second == null) {
                temp.next = fist;
                return head.next;
            }
            if (fist.val <= second.val) {
                temp.next = new ListNode(fist.val);
                fist = fist.next;
            } else {
                temp.next = new ListNode(second.val);
                second = second.next;
            }
            temp = temp.next;
        }
        return head.next;
    }


    /**
     * 1 5 7 9
     * 2 4 6 8
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }


    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * <p>
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * <p>
     * <p>
     * 1 ->  2 -> null
     * 1  <- temp  cur
     * pre
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * <p>
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return findTree(A, B);
    }


    public boolean findTree(TreeNode nodeA, TreeNode nodeB) {
        boolean result = false;
        if (nodeA != null && nodeB != null) {
            if (nodeA.val == nodeB.val) {
                result = checkNode(nodeA, nodeB);
            }
            if (!result) {
                result = findTree(nodeA.left, nodeB);
            }
            if (!result) {
                result = findTree(nodeA.right, nodeB);
            }
        }
        return result;
    }

    private boolean checkNode(TreeNode nodeA, TreeNode nodeB) {
        if (nodeB == null) {
            return true;
        }
        if (nodeA == null) {
            return false;
        }
        if (nodeA.val != nodeB.val) {
            return false;
        }
        return checkNode(nodeA.left, nodeB.left)
                && checkNode(nodeA.right, nodeB.right);
    }


    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = mirrorTree(root.left);
        TreeNode rightNode = mirrorTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null && nodeB == null) {
            return true;
        }
        if (nodeA == null || nodeB == null) {
            return false;
        }
        if (nodeA.val != nodeB.val) {
            return false;
        }
        return isSymmetric(nodeA.left, nodeB.right)
                && isSymmetric(nodeA.right, nodeB.left);
    }


    /**
     * 1  2  3  4  5
     * 2
     * 3
     * 4
     * 5
     * 6
     * 7
     * 8
     */

    private int resultIndex = 0;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int[] result = new int[rows * cols];
        while (rows > start << 1 && cols > start << 1) {
            saveInt(result, matrix, rows, cols, start);
            start++;
        }
        return result;
    }

    private void saveInt(int[] result, int[][] matrix, int rows, int cols, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        for (int i = start; i <= endX; i++) {
            result[resultIndex++] = matrix[start][i];
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                result[resultIndex++] = matrix[i][endX];
            }
        }
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                result[resultIndex++] = matrix[endY][i];
            }
        }
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                result[resultIndex++] = matrix[i][start];
            }
        }
    }

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
     * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
     * <p>
     * 示例:
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.min();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.min();   --> 返回 -2.
     * <p>
     * <p>
     * 0  0
     * 3  0
     * <p>
     * <p>
     * 0  0
     * 2  2
     */
    static class MinStack {
        private Deque<Integer> mMinStack;
        private Deque<Integer> mDateStack;

        public MinStack() {
            mMinStack = new LinkedList<>();
            mDateStack = new LinkedList<>();
        }

        public void push(int x) {
            mDateStack.push(x);
            if (mMinStack.isEmpty() || x <= mMinStack.peek()) {
                mMinStack.push(x);
            }
        }

        public void pop() {
            if (mDateStack.pop().equals(mMinStack.peek())) {
                mMinStack.pop();
            }
        }

        public int top() {
            return mDateStack.peek();
        }

        public int min() {
            return mMinStack.peek();
        }
    }


//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//
//    }


    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * <p>
     * 例如:
     * 3
     * / \
     * 9  20
     * /  \
     * 15  7
     * 返回：
     * <p>
     * [3,9,20,15,7]
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList<TreeNode> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node != null) {
                res.add(node);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i).val;
        }
        return result;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node != null) {
                    temp.add(node.val);
                    if (node.left != null) {
                        deque.offer(node.left);
                    }
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node != null) {
                    temp.add(node.val);
                    deque.offer(node.left);
                    deque.offer(node.right);
                }
            }
            if (!temp.isEmpty()) {
                result.add(temp);
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder4(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder4(res, root, 0);
        return res;
    }


    public void levelOrder4(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level < res.size()) {
            res.get(level).add(root.val);
        } else {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(temp);
        }
        levelOrder4(res, root.left, level + 1);
        levelOrder4(res, root.right, level + 1);
    }


    /**
     * 请实现一个函数按照之字形顺序打印二叉树，
     * 即第一行按照从左到右的顺序打印，
     * 第二层按照从右到左的顺序打印，
     * 第三行再按照从左到右的顺序打印，其他行以此类推。
     */
    public List<List<Integer>> levelOrderZ(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            if (!stack1.isEmpty()) {
                int level1 = stack1.size();
                for (int i = 0; i < level1; i++) {
                    TreeNode node = stack1.pop();
                    if (node != null) {
                        temp.add(node.val);
                        stack2.push(node.left);
                        stack2.push(node.right);
                    }
                }
            } else {
                int level2 = stack2.size();
                for (int i = 0; i < level2; i++) {
                    TreeNode node = stack2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        stack1.push(node.right);
                        stack1.push(node.left);
                    }
                }
            }
            if (!temp.isEmpty()) {
                res.add(temp);
            }
        }
        return res;
    }


    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果
     * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     * 参考以下这颗二叉搜索树：
     * 5
     * / \
     * 2   6
     * / \
     * 1   3
     * 示例 1：
     * 输入: [1,6,3,2,5]
     * 输出: false
     * 示例 2：
     * 输入: [1,3,2,6,5]
     * 输出: true
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return false;
        }
        if (postorder.length == 0) {
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    /**
     * 1, 2, 5, 10, 6, 9, 4, 3
     */
    public boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start == end) {
            return true;
        }
        int root = postorder[end];
        int i = start;
        for (; i < end; i++) {
            if (postorder[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < end; j++) {
            if (postorder[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > start) {
            left = verifyPostorder(postorder, start, i - 1);
        }
        boolean right = true;
        if (i < end) {
            right = verifyPostorder(postorder, i, end - 1);
        }
        return left && right;
    }


    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
     * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     * 5
     * /  \
     * 4      8
     * /      / \
     * 11     13  4
     * /  \      / \
     * 7    2   5   1
     * <p>
     * 返回:
     * [
     * [5,4,11,2],
     * [5,8,4,5]
     * ]
     * <p>
     * 提示：节点总数 <= 10000
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, sum, 0, result, new LinkedList<>());
        return result;
    }

    public void pathSum(TreeNode node, int sum, int currentNum, List<List<Integer>> result, LinkedList<Integer> tempList) {
        tempList.add(node.val);
        currentNum += node.val;
        boolean isLeaf = (node.left == null) && (node.right == null);
        if (isLeaf && currentNum == sum) {
            result.add(new LinkedList<>(tempList));
        }
        if (node.left != null) {
            pathSum(node.left, sum, currentNum, result, tempList);
        }
        if (node.right != null) {
            pathSum(node.right, sum, currentNum, result, tempList);
        }
        tempList.removeLast();
    }


    int max = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return Math.max(findBigAddNum(nums, nums.length - 1), max);
    }

    public int findBigAddNum(int arr[], int n) {
        if (n == 0) {
            max = Math.max(max, arr[0]);
            return arr[0];
        }
        int temp = Math.max(arr[n], arr[n] + findBigAddNum(arr, n - 1));
        max = Math.max(max, temp);
        return temp;
    }


    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return Math.max(res, dp[dp.length - 1]);
    }

    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i] + pre, nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }

    public int maxSubArray4(int[] nums) {
        int res = nums[0];
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            if (b > 0) {
                a += b;
            }
            if (a > res) {
                res = a;
            }
            b = a;
        }
        return res;
    }

    Node lastNode;
    Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        treeToList(root);
        if (head != null) {
            head.left = lastNode;
            lastNode.right = head;
        }
        return head;
    }

    public void treeToList(Node node) {
        if (node == null) {
            return;
        }
        treeToList(node.left);
        if (head == null) {
            head = node;
        }
        node.left = lastNode;
        if (lastNode != null) {
            lastNode.right = node;
        }
        lastNode = node;
        treeToList(node.right);
    }


    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "null";
            }
            int treeHeight = getTreeHeight(root);
            int path = 0;
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                path += 1;
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    if (node != null) {
                        builder.append(node.val);
                        builder.append(",");
                        if (path < treeHeight) {
                            deque.offer(node.left);
                            deque.offer(node.right);
                        }
                    } else {
                        builder.append("null");
                        builder.append(",");
                        if (path < treeHeight) {
                            deque.offer(null);
                            deque.offer(null);
                        }
                    }
                }
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append("]");
            return builder.toString();
        }

        private int getTreeHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            int a = 0; // '[' 或者 ‘,’  或者‘]’ 上次出现的位置
            if (data == null || data.length() == 0) {
                return null;
            }
            ArrayList<TreeNode> nodes = new ArrayList<>();
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == '[') {
                    a = i;
                } else if (data.charAt(i) == ',') {
                    addTreeNode(data, a + 1, nodes, i);
                    a = i;
                } else if (data.charAt(i) == ']') {
                    addTreeNode(data, a + 1, nodes, i);
                    a = i;
                }
            }
            return createTreeNode(nodes);
        }

        private void addTreeNode(String data, int a, ArrayList<TreeNode> nodes, int i) {
            String substring = data.substring(a, i);
            if (substring.equals("null")) {
                nodes.add(null);
            } else {
                nodes.add(new TreeNode(Integer.parseInt(substring)));
            }
        }


        public TreeNode createTreeNode(List<TreeNode> treeNodes) {
            return create(treeNodes, 0, treeNodes.size());
        }

        private TreeNode create(List<TreeNode> treeNodes, int i, int n) {
            if (i >= n) {
                return null;
            }
            if (treeNodes.get(i) == null) {
                return null;
            }
            TreeNode root = treeNodes.get(i);
            root.left = create(treeNodes, i * 2 + 1, treeNodes.size());
            root.right = create(treeNodes, i * 2 + 2, treeNodes.size());
            return root;
        }
    }


    public static class Codec2 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    if (node != null) {
                        builder.append(node.val).append(",");
                        deque.offer(node.left);
                        deque.offer(node.right);
                    } else {
                        builder.append("null,");
                    }
                }
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append("]");
            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            String[] dataList = data.substring(1, data.length() - 1).split(",");
            return create(dataList);
        }

        private TreeNode create(String[] treeNodes) {
            if (treeNodes.length == 0) {
                return null;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(treeNodes[0]));
            deque.offer(root);
            int i = 1;
            while (!deque.isEmpty()) {
                TreeNode poll = deque.poll();
                if (!treeNodes[i].equals("null")) {
                    poll.left = new TreeNode(Integer.parseInt(treeNodes[i]));
                    deque.offer(poll.left);
                }
                i++;
                if (!treeNodes[i].equals("null")) {
                    poll.right = new TreeNode(Integer.parseInt(treeNodes[i]));
                    deque.offer(poll.right);
                }
                i++;
            }
            return root;
        }
    }

    public static class Codec3 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "null";
            }
            StringBuilder builder = new StringBuilder();
            dfs(root, builder);
            return builder.substring(0, builder.length() - 1);
        }

        public void dfs(TreeNode root, StringBuilder builder) {
            if (root == null) {
                builder.append("null,");
                return;
            }
            builder.append(root.val);
            builder.append(",");
            dfs(root.left, builder);
            dfs(root.right, builder);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            Deque<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return create(queue);
        }

        private TreeNode create(Deque<String> queue) {
            String poll = queue.poll();
            if (poll.equals("null")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(poll));
            root.left = create(queue);
            root.right = create(queue);
            return root;
        }
    }


    /**
     * 剑指 Offer 38. 字符串的排列
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * 示例:
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     * 限制：
     * 1 <= s 的长度 <= 8
     * <p>
     * <p>
     * a b c
     * b a c
     * c b a
     * <p>
     * a b c
     * b a c
     * c a b
     */
    public String[] permutation(String s) {
        ArrayList<String> set = new ArrayList<>();
        permutation(s.toCharArray(), set, 0);
        return set.toArray(new String[0]);
    }

    private void permutation(char[] chars, ArrayList<String> set, int start) {
        if (start == chars.length - 1) {
            set.add(new String(chars));
            return;
        }
        boolean[] flag = new boolean[26];
        for (int i = start; i < chars.length; i++) {
            if (flag[chars[i] - 'a']) {
                continue;
            }
            flag[chars[i] - 'a'] = true;
            swap(chars, start, i);
            permutation(chars, set, start + 1);
            swap(chars, start, i);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    /**
     * 剑指 Offer 39. 数组中出现次数超过一半的数字
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 示例 1:
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     * 限制：
     * 1 <= 数组长度 <= 50000
     */
    public int majorityElement(int[] nums) {
        int times = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (times == 0) {
                res = nums[i];
                times++;
            } else {
                if (res == nums[i]) {
                    times++;
                } else {
                    times--;
                }
            }
        }
        return res;
    }


    public int majorityElement2(int[] nums) {
        int mid = nums.length >> 1;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, nums.length, start, end);
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, nums.length, start, end);
        }
        return nums[index];
    }

    /**
     * 数组分割
     */
    public int partition(int[] arr, int length, int start, int end) {
        if (arr == null || length <= 0 || start < 0 || end >= length) {
            return -1;
        }
        int index = randomInRange2(start, end);
        swap(arr, index, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                small++;
                if (small != i) {
                    swap(arr, small, i);
                }
            }
        }
        small += 1;
        swap(arr, small, end);
        return small;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int randomInRange2(int min, int max) {
        if (min == max) {
            return min;
        }
        return new Random().nextInt(max - min + 1) + min;
    }


    /**
     * 剑指 Offer 40. 最小的k个数
     * 输入整数数组 arr ，找出其中最小的 k 个数。
     * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * 示例 1：
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 示例 2：
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     * 限制：
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, arr.length, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(arr, arr.length, start, end);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    /**
     * 剑指 Offer 44. 数字序列中某一位的数字
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
     * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     * 请写一个函数，求任意第n位对应的数字。
     * 示例 1：
     * 输入：n = 3
     * 输出：3
     * 示例 2：
     * 输入：n = 11
     * 输出：0
     * 限制：
     * 0 <= n < 2^31
     */
//    public int findNthDigit(int n) {
//
//    }


    /**
     * 剑指 Offer 45. 把数组排成最小的数
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * 示例 1:
     * 输入: [10,2]
     * 输出: "102"
     * 示例 2:
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     * 提示:
     * 0 < nums.length <= 100
     */
    private double min;
    private String str;

    public String minNumber(int[] nums) {
        minNumber(nums, 0);
        return str;
    }

    private void minNumber(int[] nums, int start) {
        if (start == nums.length - 1) {
            getMin(nums);
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[start] == nums[i]) {
                continue;
            }
            swap(nums, start, i);
            minNumber(nums, start + 1);
            swap(nums, start, i);
        }
    }

    private void getMin(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
        }
        double value = Double.parseDouble(builder.toString());
        if (min != 0) {
            if (min > value) {
                min = value;
                str = builder.toString();
            }
        } else {
            min = value;
            str = builder.toString();
        }
    }


    public String minNumber2(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (o1, o2) -> {
            double a = Double.parseDouble(o1 + o2);
            double b = Double.parseDouble(o2 + o1);
            if (a < b) {
                return -1;
            } else if (a == b) {
                return 0;
            } else {
                return 1;
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);
        }
        return builder.toString();
    }

    /**
     * 剑指 Offer 46. 把数字翻译成字符串
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * 示例 1:
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     * <p>
     * 5
     * 0 1 2 3 4 5
     * <p>
     * 提示：
     * 0 <= num < 231
     * <p>
     * <p>
     * f(i)=f(i-1)+f(i-2)   i-1=0
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            char a = s.charAt(i - 2);
            char b = s.charAt(i - 1);
            int sum = (a - '0') * 10 + (b - '0');
            if (sum >= 10 && sum <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    public int translateNum2(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i == 0) {
                dp[i] = 1;
            }
            if (i == 1) {
                dp[i] = 1;
            }
            if (i >= 2) {
                int sum = (str.charAt(i - 2) - '0') * 10 + (str.charAt(i - 1) - '0');
                if (sum <= 25 && sum >= 10) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[n];
    }


    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，
     * 并每次向右或者向下移动一格、
     * 直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * 示例 1:
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     */
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = Math.max(up, left) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public int maxValue2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[n - 1][m - 1];
    }

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * <p>
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int[] last = new int[95];
        Arrays.fill(last, -1);
        char[] chars = s.toCharArray();
        int n = chars.length;
        last[chars[0] - ' '] = 0;
        int max = 1;
        int preMaxLength = 1;
        for (int i = 1; i < n; i++) {
            preMaxLength = Math.min(preMaxLength + 1, i - last[chars[i] - ' ']);
            max = Math.max(max, preMaxLength);
            last[chars[i] - ' '] = i;
        }
        return max;
    }


    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * 示例:
     * s = "abaccdeff"
     * 返回 "b"
     * s = ""
     * 返回 " "
     * 限制：
     * 0 <= s 的长度 <= 50000
     */
    public char firstUniqChar(String s) {
        char res = ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                Integer integer = map.get(c);
                map.put(c, integer + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> next : map.entrySet()) {
            if (next.getValue() == 1) {
                return next.getKey();
            }
        }
        return res;
    }


    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点
     * 输入两个链表，找出它们的第一个公共节点。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = (tempA != null) ? tempA.next : headB;
            tempB = (tempB != null) ? tempB.next : headA;
        }
        return tempA;
    }


    /**
     * 剑指 Offer 53 - I. 在排序数组中查找数字 I
     * 统计一个数字在排序数组中出现的次数。
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     * 示例 2:
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     * 限制：
     * 0 <= 数组长度 <= 50000
     */
    public int search(int[] nums, int target) {
        int firstK = getFirstK(nums, target, 0, nums.length - 1);
        int lastK = getLastK(nums, target, 0, nums.length - 1);
        if (firstK > -1 && lastK > -1) {
            return lastK - firstK + 1;
        }
        return 0;
    }

    public int getFirstK(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        int num = nums[mid];
        if (target > num) {
            start = mid + 1;
        }
        if (target < num) {
            end = mid - 1;
        }
        if (num == target) {
            if (mid > 0 && nums[mid - 1] != target || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        }
        return getFirstK(nums, target, start, end);
    }

    public int getLastK(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        int num = nums[mid];
        if (target > num) {
            start = mid + 1;
        }
        if (target < num) {
            end = mid - 1;
        }
        if (num == target) {
            if (mid < end && nums[mid + 1] != target || mid == end) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return getLastK(nums, target, start, end);
    }


    /**
     * 剑指 Offer 53 - II. 0～n-1中缺失的数字
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * 示例 1:
     * 输入: [0,1,3]
     * 输出: 2
     * 示例 2:
     * 输入: [0,1,2,3,4,5,6,7,9]
     * 输出: 8
     */
    public int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == mid) {
                start = mid + 1;
            } else if (nums[mid] > mid) {
                if (mid > 0) {
                    if (nums[mid - 1] == mid - 1) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                }
                if (mid == 0) {
                    return mid;
                }
            }
        }
        return start;
    }


    /**
     * 剑指 Offer 54. 二叉搜索树的第k大节点
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     * 示例 1:
     * 输入: root = [3,1,4,null,2], k = 1
     * 3
     * / \
     * 1   4
     * \
     * 2
     * 输出: 4
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     * 5
     * / \
     * 3   6
     * / \
     * 2   4
     * /
     * 1
     * 输出: 4
     */
//    public int kthLargest(TreeNode root, int k) {
//        ArrayList<Integer> res = new ArrayList<>();
//        kthLargest(root, res);
//        return res.get(res.size() - k);
//    }
//
//    public void kthLargest(TreeNode root, ArrayList<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        kthLargest(root.left, res);
//        res.add(root.val);
//        kthLargest(root.right, res);
//    }
    int k;
    int res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        kthLargest(root);
        return res;
    }

    public void kthLargest(TreeNode root) {
        if (root == null) {
            return;
        }
        kthLargest(root.right);
        if (k == 0) {
            return;
        }
        if (k-- == 1) {
            res = root.val;
            return;
        }
        kthLargest(root.left);
    }


    /**
     * 剑指 Offer 55 - I. 二叉树的深度
     * 输入一棵二叉树的根节点，求该树的深度。
     * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
     * 最长路径的长度为树的深度。
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return res;
    }


    /**
     * 剑指 Offer 56 - I. 数组中数字出现的次数
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     * <p>
     * 示例 1：
     * 输入：nums = [4,1,4,6]
     * 输出：[1,6] 或 [6,1]
     * 示例 2：
     * 输入：nums = [1,2,10,4,1,4,3,3]
     * 输出：[2,10] 或 [10,2]
     * 限制：
     * 2 <= nums.length <= 10000
     */
    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        int y = 1;
        while ((temp & y) == 0) {
            y <<= 1;
        }
        int res1 = 0;
        int res2 = 0;
        for (int num : nums) {
            if ((num & y) == 0) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }
        return new int[]{res1, res2};
    }

    public int findFirstBitIndex(int num) {
        int index = 0;
        int temp = 1;
        while ((num & temp) == 0) {
            temp <<= 1;
            index++;
        }
        return index;
    }


    /**
     * 剑指 Offer 56 - II. 数组中数字出现的次数 II
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * 示例 1：
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * 示例 2：
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     * 限制：
     * 1 <= nums.length <= 10000
     * 1 <= nums[i] < 2^31
     */
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < bits.length; j++) {
                if ((nums[i] & temp) != 0) {
                    bits[j] += 1;
                }
                temp = temp << 1;
            }
        }
        int res = 0;
        int m = 3;
        for (int i = 0; i < bits.length; i++) {
            res <<= 1;
            res |= bits[31 - i] % m;
        }
        return res;
    }


    /**
     * 剑指 Offer 57. 和为s的两个数字
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，
     * 使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     * 限制：
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{temp, nums[i]};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    public int[] twoSum2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            long temp = nums[start] + nums[end];
            if (temp < target) {
                start++;
            } else if (temp == target) {
                return new int[]{nums[start], nums[end]};
            } else {
                end--;
            }
        }
        return new int[2];
    }


    /**
     * 剑指 Offer 57 - II. 和为s的连续正数序列
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     * 示例 1：
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     * 示例 2：
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     * 限制：
     * 1 <= target <= 10^5
     */
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int start = 1, end = 2; start < end; ) {
            int sum = (start + end) * (end - start + 1) / 2;
            if (sum == target) {
                int[] temp = new int[end - start + 1];
                for (int p = 0, i = start; i <= end; i++) {
                    temp[p++] = i;
                }
                res.add(temp);
                start++;
            } else if (sum < target) {
                end++;
            } else {
                start++;
            }
        }
        return res.toArray(new int[0][]);
    }


    /**
     * 剑指 Offer 58 - I. 翻转单词顺序
     * 输入一个英文句子，翻转句子中单词的顺序，
     * 但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串"I am a student. "，则输出"student. a am I"。
     * 示例 1：
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * 示例 2：
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        String temp = s.trim();
        int l = 0;
        int r = 0;
        while (temp.contains(" ")) {
            r = temp.indexOf(" ");
            String s1 = temp.substring(l, r).trim();
            String s2 = reverseWord(s1.toCharArray(), 0, s1.length() - 1);
            builder.append(s2).append(" ");
            temp = temp.substring(r + 1).trim();
        }
        String s1 = reverseWord(temp.toCharArray(), 0, temp.length() - 1);
        builder.append(s1);
        return builder.reverse().toString();
    }

    public String reverseWord(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }


    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] strings = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) {
                continue;
            }
            builder.append(strings[i]).append(" ");
        }
        return builder.toString().trim();
    }

//    "example   good a"

    public String reverseWords3(String s) {
        String str = s.trim();
        System.out.println(str);
        int r = str.length() - 1;
        int l = r;
        StringBuilder builder = new StringBuilder();
        while (l >= 0) {
            while (l >= 0 && str.charAt(l) != ' ') l--;
            builder.append(str.substring(l + 1, r + 1)).append(" ");
            while (l >= 0 && str.charAt(l) == ' ') l--;
            r = l;
        }
        return builder.toString().trim();
    }


    /**
     * 剑指 Offer 59 - I. 滑动窗口的最大值
     * 给定一个数组 nums 和滑动窗口的大小 k，
     * 请找出所有滑动窗口里的最大值。
     * 示例:
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * <p>
     * 提示：
     * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int l = 0;
        int r = k - 1;
        int[] res = new int[nums.length - k + 1];
        int p = 0;
        while (r < nums.length) {
            int temp = nums[l];
            for (int i = l; i <= r; i++) {
                temp = Math.max(nums[i], temp);
            }
            res[p++] = temp;
            r++;
            l++;
        }
        return res;
    }


    /**
     * 剑指 Offer 59 - II. 队列的最大值
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
     * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
     * 若队列为空，pop_front 和 max_value 需要返回 -1
     * 示例 1：
     * 输入:
     * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     * [[],[1],[2],[],[],[]]
     * 输出: [null,null,null,2,1,2]
     * 示例 2：
     * <p>
     * 输入:
     * ["MaxQueue","pop_front","max_value"]
     * [[],[],[]]
     * 输出: [null,-1,-1]
     * <p>
     * 限制：
     * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
     * 1 <= value <= 10^5
     */
    public static class MaxQueue {
        Deque<Integer> mDeque = new LinkedList<>();
        Queue<Integer> mQueue = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            if (mDeque.isEmpty()) {
                return -1;
            }
            return mDeque.peekFirst();
        }

        public void push_back(int value) {
            while (!mDeque.isEmpty() && mDeque.peekLast() < value) {
                mDeque.pollLast();
            }
            mDeque.offerLast(value);
            mDeque.offer(value);
        }

        public int pop_front() {
            if (mQueue.isEmpty()) {
                return -1;
            }
            int value = mQueue.poll();
            while (mDeque.peekFirst() != null && mDeque.peekFirst() == value) {
                mDeque.pollFirst();
            }
            return value;
        }
    }


    /**
     * 剑指 Offer 60. n个骰子的点数
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     * 示例 1:
     * 输入: 1
     * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
     * 示例 2:
     * 输入: 2
     * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
     * 限制：
     * 1 <= n <= 11
     */
//    public double[] dicesProbability(int n) {
//
//    }
    private void fun1(int n) {
        if (n < 1) {
            return;
        }
        int maxSum = n * 6;
        double[] res = new double[maxSum - n + 1];
    }

    private void fun2(int n, double[] arr) {
        for (int i = 1; i <= 6; i++) {
            fun3(n, n, i, arr);
        }
    }

    private void fun3(int original, int current, int sum, double[] arr) {
        if (current == 1) {
            arr[sum - original] += 1;
        } else {

        }
    }

    /**
     * 剑指 Offer 61. 扑克牌中的顺子
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     * 示例 1:
     * 输入: [1,2,3,4,5]
     * 输出: True
     * 示例 2:
     * 输入: [0,0,1,2,5]
     * 输出: True
     * 限制：
     * 数组长度为 5
     * 数组的数取值为 [0, 13]
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (set.contains(nums[i])) {
                    return false;
                }
                set.add(nums[i]);
                min = Math.min(nums[i], min);
                max = Math.max(nums[i], max);
            }
        }
        return max - min < 5;
    }

    public boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                return false;
            }
        }
        return nums[nums.length - 1] - nums[zero] < 5;
    }

    public boolean isStraight3(int[] nums) {
        int bit = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (((1 << nums[i]) & bit) != 0) {
                    return false;
                }
                bit |= 1 << nums[i];
                min = Math.min(nums[i], min);
                max = Math.max(nums[i], max);
            }
        }
        return max - min < 5;
    }

    /**
     * 剑指 Offer 63. 股票的最大利润
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * 限制：
     * 0 <= 数组长度 <= 10^5
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int temp = prices[i] - min;
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }


    /**
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     * 示例 1:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * 示例 2:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     * 说明:
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    /**
     * 剑指 Offer 68 - II. 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * 示例 1:
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     * 说明:
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> res1 = new ArrayList<>();
        ArrayList<TreeNode> res2 = new ArrayList<>();
        LinkedList<TreeNode> temp1 = new LinkedList<>();
        LinkedList<TreeNode> temp2 = new LinkedList<>();
        getPath(root, p, temp1, res1);
        getPath(root, q, temp2, res2);
        TreeNode temp = null;
        for (int i = 0; i < res1.size() && i < res2.size(); i++) {
            if (res1.get(i).val == res2.get(i).val) {
                temp = res1.get(i);
            } else {
                break;
            }
        }
        return temp;
    }

    public void getPath(TreeNode root, TreeNode treeNode, LinkedList<TreeNode> tempList, ArrayList<TreeNode> res) {
        if (root == null || !res.isEmpty()) {
            return;
        }
        tempList.add(root);
        if (root.val == treeNode.val) {
            res.addAll(new ArrayList<>(tempList));
            return;
        }
        if (root.left != null) {
            getPath(root.left, treeNode, tempList, res);
        }
        if (root.right != null) {
            getPath(root.right, treeNode, tempList, res);
        }
        tempList.removeLast();
    }


    Map<Integer, TreeNode> mMap = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        setParentValue(root);
        TreeNode node = p;
        while (node != null) {
            set.add(node);
            node = mMap.get(node.val);
        }

        TreeNode node1 = q;
        while (node1 != null) {
            if (set.contains(node1)) {
                return node1;
            }
            node1 = mMap.get(node1.val);
        }
        return null;
    }

    public void setParentValue(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            mMap.put(root.left.val, root);
            setParentValue(root.left);
        }
        if (root.right != null) {
            mMap.put(root.right.val, root);
            setParentValue(root.right);
        }
    }

    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor4(root.left, p, q);
        TreeNode right = lowestCommonAncestor4(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

}



