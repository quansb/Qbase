package com.example.leetcode.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Tree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode createTree(Object[] arr, int i, int n) {
        if (i >= n) {
            return null;
        }
        if (arr[i] == null) {
            return null;
        }
        TreeNode root = new TreeNode((Integer) arr[i]);
        root.left = createTree(arr, i * 2 + 1, arr.length);
        root.right = createTree(arr, i * 2 + 2, arr.length);
        return root;
    }

    /**
     * 中序遍历
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.val);
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        Object[] arr = {5, 1, 4, null, null, 3, 6};
        TreeNode head = createTree(arr, 0, arr.length);

//        inOrderTraversal(head);
//        Info process = process(head);
//        long[] pre = {Long.MIN_VALUE};
//        System.out.println(inOrderTraversalIsTbs(head, pre));


        //  dfs(head);
        bfs(head);
//        doWork(() -> process3(30));
//        doWork(() -> process(30));
//        doWork(() -> pro(92));
//        doWork(() -> process2(7));
//        doWork(() -> pro2(35));
//        doWork(() -> process10(35, 0));
//        doWork(() -> process12(35));
//        doWork(() -> numWays(1000000));
//        doWork(() -> waysToStep(60));
//        doWork(() -> waysToStep2(61));
//        doWork(() -> process(createRandomArray2(100, 10 * 10 * 10 * 10)));
//        doWork(() -> subsets(createRandomArray(20, 100)));
//        doWork(() -> subsets2(array2));
//        doWork(() -> subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }

    public static Info process(TreeNode node) {
        if (node == null) {
            return null;
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        int min = node.val;
        int max = node.val;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        boolean isAllBts = false;
        if ((leftInfo == null || leftInfo.max < node.val)
                && (rightInfo == null || rightInfo.min > node.val)
                && (leftInfo == null || leftInfo.isAllBts)
                && (rightInfo == null || rightInfo.isAllBts)
        ) {
            isAllBts = true;
        }
        return new Info(isAllBts, min, max);
    }

    public static class Info {
        private boolean isAllBts;
        private int min;
        private int max;

        public Info() {
        }

        public Info(boolean isAllBts, int min, int max) {
            this.isAllBts = isAllBts;
            this.min = min;
            this.max = max;
        }
    }

    public static boolean inOrderTraversalIsTbs(TreeNode node, long[] arr) {
        if (node == null) {
            return true;
        }
        boolean left = inOrderTraversalIsTbs(node.left, arr);
        if (arr[0] > node.val) {
            return false;
        }
        arr[0] = node.val;
        boolean right = inOrderTraversalIsTbs(node.right, arr);
        return left && right;
    }

    public static void DFS(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        DFS(head.left);
        DFS(head.right);
    }

    public static void bfs(TreeNode head) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 按层打印
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        BFS(root, res);
        return res;
    }


    public static void BFS(TreeNode root, List<List<Integer>> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    temp.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            res.add(0, new LinkedList<>(temp));
        }
    }

    /**
     * 按层打印
     * 3
     * / \
     * 9   20
     * /  \
     * 15   7
     */
    public static List<List<Integer>> levelOrderDfs(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new LinkedList<>());
        DFS(root, 0, res);
        return res;
    }

    public static void DFS(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (level < res.size()) {
            res.get(level).add(node.val);
        } else {
            List<Integer> temp = new LinkedList<>();
            temp.add(node.val);
            res.add(temp);
        }
        DFS(node.left, level + 1, res);
        DFS(node.right, level + 1, res);
    }


    /**
     * 爬楼梯一次能爬 一步 或者两步 所有可能  暴力递归
     */
    public static int process(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int sum1 = process(n - 1);
        int sum2 = process(n - 2);
        return sum1 + sum2;
    }


    /**
     * 爬楼梯一次能爬 一步 或者两步 所有可能   记忆化搜索
     */
    public static long pro(int n) {
        long[] dp = new long[n];
        return process(n, dp);
    }

    /**
     * 爬楼梯一次能爬 一步 或者两步 所有可能   记忆化搜索
     */
    public static long process(int n, long[] dp) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (dp[n - 1] == 0) {
            dp[n - 1] = process(n - 1, dp);
        }
        if (dp[n - 2] == 0) {
            dp[n - 2] = process(n - 2, dp);
        }
        return dp[n - 1] + dp[n - 2];
    }

    /**
     * 爬楼梯一次能爬 一步 或者两步 所有可能   动态规划  572466946
     */
    public static long process2(int n) {
        long[] dp = new long[n + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = 1;
            }
            if (i == 2) {
                dp[i] = 2;
            }
            if (i > 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    /**
     * 爬楼梯一次能爬 一步 或者两步 所有可能   状态压缩,只需要保留前2项数据
     */
    public static int process3(int n) {
        int a = 0;
        int b = 1;
        int c = 2;
        for (int i = 1; i < n + 1; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return a;
    }


    /**
     * 爬楼梯一次能爬 一步 或者两步   两步的时候只能一次  暴力递归
     */
    public static long process10(int n, int status) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            if (status == 0 || status == 1) {
                return 2;
            } else if (status == 2) {
                return 1;
            }
        }
        long left = 0;
        long right = 0;
        if (status == 0 || status == 1) {
            left = process10(n - 1, 1);
            right = process10(n - 2, 2);
        } else if (status == 2) {
            left = process10(n - 1, 1);
        }
        return left + right;
    }

    /**
     * 爬楼梯一次能爬 一步 或者两步 不能连续两次2步   记忆化搜索
     */
    public static long pro2(int n) {
        long[][] dp = new long[n][3];
        return process11(n, 0, dp);
    }

    /**
     * 爬楼梯一次能爬 一步 或者两步   两步的时候只能一次  记忆化搜索
     */
    public static long process11(int n, int status, long dp[][]) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            if (status == 0 || status == 1) {
                return 2;
            } else if (status == 2) {
                return 1;
            }
        }
        long left = 0;
        long right = 0;
        if (status == 0 || status == 1) {
            if (dp[n - 1][1] == 0) {
                left = dp[n - 1][1] = process11(n - 1, 1, dp);
            } else {
                left = dp[n - 1][1];
            }
            if (dp[n - 2][2] == 0) {
                right = dp[n - 2][2] = process11(n - 2, 2, dp);
            } else {
                right = dp[n - 2][2];
            }
        }
        if (status == 2) {
            if (dp[n - 1][1] == 0) {
                left = dp[n - 1][1] = process11(n - 1, 1, dp);
            } else {
                left = dp[n - 1][1];
            }
        }
        return left + right;
    }

    /**
     * 爬楼梯一次能爬 一步 或者两步   两步的时候只能一次  动态规划
     */
    public static long process12(int n) {
        long[][] dp = new long[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                }
                if (i == 2) {
                    if (j == 1) {
                        dp[i][j] = 2;
                    }
                    if (j == 2) {
                        dp[i][j] = 1;
                    }
                }
                if (i > 2) {
                    if (j == 1) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 2][j + 1];
                    }
                    if (j == 2) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[n][1];
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 输入：n = 2
     * 输出：2
     * 输入：n = 7
     * 输出：21
     * 输入：n = 0
     * 输出：1
     */
    public static int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = 1;
            }
            if (i == 2) {
                dp[i] = 2;
            }
            if (i > 2) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }
        }
        return dp[n];
    }

    /**
     * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
     * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
     * 输入：n = 3
     * 输出：4
     * 说明: 有四种走法
     * <p>
     * 输入：n = 5
     * 输出：13
     */
    public static int waysToStep(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = 1;
            }
            if (i == 2) {
                dp[i] = 2;
            }
            if (i == 3) {
                dp[i] = 4;
            }
            if (i > 3) {
                dp[i] = (dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007 + dp[i - 3] % 1000000007) % 1000000007;
            }
        }
        return dp[n];
    }

    public static int waysToStep2(int n) {
        int a = 0;
        int b = 1;
        int c = 2;
        int d = 4;
        for (int i = 1; i < n + 1; i++) {
            a = b;
            b = c;
            c = d;
            d = a + b + c;
            a %= 1000000007;
            b %= 1000000007;
            c %= 1000000007;
            d %= 1000000007;
        }
        return a;
    }


    public static List<List<Integer>> subsets3(int[] nums) {
        ArrayList<List<Integer>> resList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

        }
        return resList;
    }

    /**
     * 给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     */
    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> resList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        DFS(0, nums, tempList, resList);
        return resList;
    }

    private static void DFS(int n, int[] nums, ArrayList<Integer> tempList, ArrayList<List<Integer>> resList) {
        if (n == nums.length) {
            resList.add(new ArrayList<>(tempList));
            return;
        }
        tempList.add(nums[n]);
        DFS(n + 1, nums, tempList, resList);
        tempList.remove(tempList.size() - 1);
        DFS(n + 1, nums, tempList, resList);
    }

    /**
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,2]
     * 输出:
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<List<Integer>> resList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        dfs3(0, nums, tempList, resList, set);
        return resList;
    }


    private static void dfs3(int n, int[] nums, ArrayList<Integer> tempList, ArrayList<List<Integer>> resList, Set<ArrayList<Integer>> set) {
        if (n == nums.length) {
            ArrayList<Integer> integers = new ArrayList<>(tempList);
            if (!set.contains(integers)) {
                set.add(integers);
                resList.add(integers);
            }
            return;
        }
        tempList.add(nums[n]);
        dfs3(n + 1, nums, tempList, resList, set);
        tempList.remove(tempList.size() - 1);
        dfs3(n + 1, nums, tempList, resList, set);
    }


    /**
     * 1 2 3
     * <p>
     * <p>
     * 000      0  []
     * 001      1  [1]
     * 010      2  [2]
     * 011      3  [1,2]
     * 100      4  [3]
     * 101      5  [1,3]
     * 110      6  [2,3]
     * 111      7  [1,2,3]
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        ArrayList<List<Integer>> resList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        bitOperation(nums, tempList, resList);
        System.out.println("subsets2");
        return resList;
    }

    public static ArrayList<List<Integer>> bitOperation(int[] nums, ArrayList<Integer> tempList, ArrayList<List<Integer>> resList) {
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            tempList.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    tempList.add(nums[j]);
                }
            }
            resList.add(new ArrayList<>(tempList));
        }
        return resList;
    }


}