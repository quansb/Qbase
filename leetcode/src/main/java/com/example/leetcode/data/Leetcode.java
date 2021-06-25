package com.example.leetcode.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.data.Offer.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author quanshibao
 * @description
 * @date 2021/4/25
 */
public class Leetcode {

    public static void main(String[] args) {
        Leetcode leetcode = new Leetcode();
    }


    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 示例 1：
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * 输入：n = 1
     * 输出：["()"]
     * 提示：
     * 1 <= n <= 8
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


    /**
     * 200. 岛屿数量
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numIslands(char[][] grid) {
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

    public int dfs(char[][] grid, int vertical, int horizon) {
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

    private static boolean isValid(char[][] grid, int vertical, int horizon) {
        return vertical >= 0 && vertical < grid.length && horizon >= 0 && horizon < grid[0].length;
    }


    /**
     * 897. 递增顺序搜索树
     * 给你一棵二叉搜索树，
     * 请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
     * 使树中最左边的节点成为树的根节点，
     * 并且每个节点没有左子节点，只有一个右子节点。
     */
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for (int i = 0; i < res.size(); i++) {
            TreeNode treeNode = new TreeNode(res.get(i));
            currNode.right = treeNode;
            currNode = treeNode;
        }
        return dummyNode.right;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }


    /**
     * 633. 平方数之和
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
     * 示例 1：
     * 输入：c = 5
     * 输出：true
     * 解释：1 * 1 + 2 * 2 = 5
     */
    public boolean judgeSquareSum(int c) {
        for (int a = 0; a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (Double.isNaN(b)) {
                return false;
            }
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    /**
     * 692. 前K个高频单词
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     * <p>
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     * <p>
     * 示例 1：
     * <p>
     * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * 输出: ["i", "love"]
     * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     * 注意，按字母顺序 "i" 在 "love" 之前。
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> (map.get(o2).equals(map.get(o1))) ? o1.compareTo(o2) : map.get(o2) - map.get(o1));
        return list.subList(0, k);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((entry1, entry2) ->
                entry1.getValue().equals(entry2.getValue()) ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue());
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            arrayList.add(priorityQueue.poll().getKey());
        }
        Collections.reverse(arrayList);
        return arrayList;
    }


    /**
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     * <p>
     * 示例 1:
     * 输入: 2, [[1,0]]
     * 输出: [0,1]
     * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     * 示例 2:
     * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
     * 输出: [0,1,2,3] or [0,2,1,3]
     * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
     * 说明:
     * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
     * 你可以假定输入的先决条件中没有重复的边。
     * 提示:
     * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
     * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
     * 拓扑排序也可以通过 BFS 完成。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/course-schedule-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */

    private boolean valid = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[numCourses];
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            res.add(new ArrayList<>());
        }
        for (int[] temp : prerequisites) {
            res.get(temp[1]).add(temp[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(res, i, stack, visited);
            }
            if (!valid) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            result[index++] = pop;
        }
        return result;
    }

    public void dfs(List<List<Integer>> res, int i, LinkedList<Integer> stack, int[] visited) {
        visited[i] = 1;
        for (int a : res.get(i)) {
            if (visited[a] == 0) {
                dfs(res, a, stack, visited);
                if (!valid) {
                    return;
                }
            } else if (visited[a] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
        stack.push(i);
    }


    class Solution {
        // 存储有向图
        List<List<Integer>> res;
        // 存储每个节点的入度
        int[] in;
        // 存储答案
        int[] result;
        // 答案下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            res = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                res.add(new ArrayList<>());
            }
            result = new int[numCourses];
            in = new int[numCourses];
            for (int[] info : prerequisites) {
                res.get(info[1]).add(info[0]);
                in[info[0]] += 1;
            }
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (in[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int poll = queue.poll();
                result[index++] = poll;
                for (int p : res.get(poll)) {
                    in[p] -= 1;
                    if (in[p] == 0) {
                        queue.offer(p);
                    }
                }
            }
            if (index != numCourses) {
                return new int[0];
            }
            return result;
        }
    }


    /**
     * 347. 前 K 个高频元素
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     * 示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     * 输入: nums = [1], k = 1
     * 输出: [1]
     * 提示：
     * 1 <= nums.length <= 105
     * k 的取值范围是 [1, 数组中不相同的元素的个数]
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
     * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] res = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int t = 0;
        while (!queue.isEmpty()) {
            res[t++] = queue.poll().getKey();
        }
        return res;
    }


}
