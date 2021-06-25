package com.example.leetcode.base;

import com.example.base.tree.Node;
import com.example.data.Offer.TreeNode;

import java.util.List;
import java.util.Random;

public class DataFactory {

    public static int[] createRandomArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }


    /**
     * 生成随机数组
     */
    public static int[] createRandomArray2(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max * (Math.random() > 0.5 ? 1 : -1));
        }
        return arr;
    }

    /**
     * 使用数组完全二叉树的格式来创建树
     */
    public static TreeNode createTreeNode(Object[] arr) {
        return createTree(arr, 0, arr.length);
    }

    private static TreeNode createTree(Object[] arr, int i, int n) {
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


    public static Node createNode(Object[] arr) {
        return createNode(arr, 0, arr.length);
    }

    private static Node createNode(Object[] arr, int i, int n) {
        if (i >= n) {
            return null;
        }
        if (arr[i] == null) {
            return null;
        }
        Node root = new Node((Integer) arr[i]);
        root.left = createNode(arr, i * 2 + 1, arr.length);
        root.right = createNode(arr, i * 2 + 2, arr.length);
        return root;
    }

    public static <T> void printTree(T root) {
        if (root == null) {
            return;
        }
        if (root instanceof TreeNode) {
            System.out.println(((TreeNode) root).val);
            printTree(((TreeNode) root).left);
            printTree(((TreeNode) root).right);
        } else if (root instanceof Node) {
            System.out.println(((Node) root).val);
            printTree(((Node) root).left);
            printTree(((Node) root).right);
        }
    }

    public static int randomInRange(int min, int max) {
        return (int) (Math.random() * (max + 1 - min)) + min;
    }

    public static int randomInRange2(int min, int max) {
        if (min == max) {
            return min;
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    public static void printArr(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            if (i != arr.length - 1) {
                builder.append(',');
            }
        }
        System.out.println(builder.toString());
    }

    public static void printStr(String[] strings) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);
            if (i != strings.length - 1) {
                builder.append(',');
            }
        }
        System.out.println(builder.toString());
    }

    public static <T> void printList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            System.out.println(t);
        }
    }

    private int res = 0;
    private int temp = 0;

    public void kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        kthSmallest(root.left, k);
        temp++;
        if (temp == k) {
            res = root.val;
            return;
        }
        kthSmallest(root.right, k);
    }

    public void process(TreeNode node, List<TreeNode> res, int k) {
        if (res.size() == k || node == null) {
            return;
        }
        process(node.left, res, k);
        res.add(node);
        process(node.right, res, k);
    }


}
