package com.example.leetcode.test;

import java.util.Stack;

public class ListTest {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }


    /**
     *快慢指针判断链表是否有环
     */
    private static boolean process(ListNode node) {
        if (node == null) {
            return false;
        }
        if (node.next == null) {
            return false;
        }
        if (node.next.next == null) {
            return false;
        }
        ListNode fast = node.next;
        ListNode slow = node.next.next;
        while (true) {
            if (slow == fast) {
                return true;
            }
            if (fast.next == null) {
                return false;
            }
            fast = fast.next;
            if (slow.next == null || slow.next.next == null) {
                return false;
            }
            slow = slow.next.next;
        }
    }


    /**
     * 当前这轮先手在L..R范围上能取得的分数
     */
    public static int f(int[] arr, int L, int R) {
        //当前只有一张牌,因为当前先手,因此拿掉
        if (L == R) {
            return arr[L];
        }
        //当前有多张牌, 先手可以拿L 或者R牌,   不仅仅需要考虑当前L和R的大小，
        // 还要考虑自己拿走了L或者R,剩下的牌中再次轮到自己后手时能拿到的牌
        return Math.max((arr[L] + s(arr, L + 1, R)), (arr[R] + s(arr, L, R - 1)));
    }

    /**
     * 当前这轮后手在L..R范围上能取得的分数
     */
    private static int s(int[] arr, int L, int R) {
        //如果只有一张牌,后手没得选
        if (L == R) {
            return 0;
        }
        //如果有牌, 先手会先拿掉一张牌，再轮到后手，
        //先手要么拿L牌，要么拿R牌 ,因此后手只能从 L+1...R范围或者 L...R-1范围拿牌
        //所以后手拿牌就是  f(arr, L + 1, R) 或者  f(arr, L, R - 1)
        //玩家绝顶聪明, 先手玩家会让后手玩家拿到最小值
        return Math.min(f(arr, L + 1, R), f(arr, L, R - 1));
    }


    public static ListNode process3(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        ListNode l = null;
        while (cur != null) {
            l = cur;
            stack.add(cur);
            cur = cur.next;
            l.next = null;
        }

        ListNode head2 = null;
        if (!stack.empty()) {
            head2 = stack.pop();
        }
        ListNode next = head2;
        while (!stack.empty()) {
            next.next = stack.pop();
            next = next.next;
        }
        return head2;
    }

    public static ListNode process4(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur = cur.next;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }


    //  1 200 3 4       1 4  200 3                  4  200
}
