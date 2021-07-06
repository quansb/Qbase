package com.example.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author quanshibao
 * @description
 * @date 2021/7/6
 */
public class LeetCode445 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 445. 两数相加 II
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * <p>
     * 进阶：
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     * 示例：
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        ListNode t1 = l1; //不改变原有链表头结点
        ListNode t2 = l2;
        while (t1 != null) {
            stack1.push(t1.val);
            t1 = t1.next;
        }
        while (t2 != null) {
            stack2.push(t2.val);
            t2 = t2.next;
        }
        ListNode head = null; //用来指向头结点
        int v = 0;   //当前位的值
        int c = 0;   //进位
        while (stack1.peek() != null || stack2.peek() != null) {
            int a = stack1.peek() == null ? 0 : stack1.pop();  //其中一个结点为空则补0
            int b = stack2.peek() == null ? 0 : stack2.pop();
            v = (a + b + c) % 10;
            c = (a + b + c) / 10;
            ListNode temp = new ListNode(v);
            temp.next = head;
            head = temp;
        }
        if (c > 0) {     //两个链表都为空，是否还有进位
            ListNode temp = new ListNode(c);
            temp.next = head;
            head = temp;
        }
        return head;
    }


}
