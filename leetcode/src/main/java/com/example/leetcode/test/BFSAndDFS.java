package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class BFSAndDFS {


    public static void main(String[] args) {

    }

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * 输出：3
     * <p>
     * 输入：grid = [
     * * ["0","1","0","0","0"],
     * * ["1","0","0","0","0"],
     * * ["0","0","1","0","0"],
     * * ["0","0","0","1","1"]
     * * ]
     */
    public static int numIslands(char[][] grid) {

        int res = 0;
        int vertical = grid.length;
        int horizon = grid[0].length;
        for (int i = 0; i < vertical; i++) {
            for (int j = 0; j < horizon; j++) {
                if (grid[i][j] == '1') {
                    int temp = dfs(grid, i, j);
                    if (temp > 0) {
                        res++;
                    }
                }

            }
        }
        return res;
    }


    /**
     * n
     * m  0  1
     */

    public static int dfs(char[][] grid, int vertical, int horizon) {
        if (!isValid(grid, vertical, horizon)) {
            return 0;
        }
        if (grid[vertical][horizon] != '1') {
            return 0;
        }
        grid[vertical][horizon] = '2';
        dfs(grid, vertical - 1, horizon);
        dfs(grid, vertical, horizon - 1);
        dfs(grid, vertical + 1, horizon);
        dfs(grid, vertical, horizon + 1);
        return 1;
    }


    public static int dfs(char[][] grid, int vertical, int horizon, int[][] dp) {
        if (!isValid(grid, vertical, horizon)) {
            return 0;
        }
        if (grid[vertical][horizon] != '1') {
            return 0;
        }
        grid[vertical][horizon] = '2';
        if (dp[vertical][horizon] != 0) {
            return dp[vertical][horizon];
        }
        dfs(grid, vertical - 1, horizon, dp);
        dfs(grid, vertical, horizon - 1, dp);
        dfs(grid, vertical + 1, horizon, dp);
        dfs(grid, vertical, horizon + 1, dp);
        dp[vertical][horizon] = 1;
        return 1;
    }

    private static boolean isValid(char[][] grid, int vertical, int horizon) {
        return vertical >= 0 && vertical < grid.length && horizon >= 0 && horizon < grid[0].length;
    }


    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
     * <p>
     * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * 输入：root = [1,null,3,2,4,null,5,6]
     * 输出：[[1],[3,2,4],[5,6]]
     */
//    public static List<List<Integer>> levelOrder(Node root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        //  test.DFS.dfs(res, root, 0);
//        return res;
//    }


    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：["()"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, n, 0, 0, "");
        return res;
    }
    public static void backtrack(List<String> res, int n, int leftNum, int rightNum, String temp) {
        if (rightNum > leftNum) {
            return;
        }
        if (leftNum == n && rightNum == n) {
            res.add(temp);
            return;
        }
        if (leftNum < n) {
            backtrack(res, n, leftNum + 1, rightNum, temp + "(");
        }
        if (rightNum < leftNum) {
            backtrack(res, n, leftNum, rightNum + 1, temp + ")");
        }
    }



}
