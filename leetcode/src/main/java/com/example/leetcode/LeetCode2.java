package com.example.leetcode;

/**
 * @author quanshibao
 * @description
 * @date 2021/7/6
 */
public class LeetCode2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 2. 两数相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 示例 1：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     * 提示：
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     */


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode h1 = head;
        int c = 0;
        int v = 0;
        ListNode t1 = l1; //不改变原有链表结构
        ListNode t2 = l2;
        while (t1 != null || t2 != null) {
            int a = t1 == null ? 0 : t1.val;  //其中一个为空则补0
            int b = t2 == null ? 0 : t2.val;
            v = (a + b + c) % 10;      //当前位的值
            c = (a + b + c) / 10;      //进位
            h1.next = new ListNode(v);
            h1 = h1.next;
            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }
        if (c > 0) {     //两个链表都为空，是否还有进位
            h1.next = new ListNode(c);
        }
        return head.next;
    }


}
