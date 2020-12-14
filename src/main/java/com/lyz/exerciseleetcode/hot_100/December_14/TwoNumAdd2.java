package com.lyz.exerciseleetcode.hot_100.December_14;

/**
 * @author LYZ
 * @date 2020/12/14 13:53
 * <p>
 * 2. 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumAdd2 {
    /**
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * [9,9,9,9,9,9,9]
     * [9,9,9,9]
     * [8,9,9,9,0,0,0,1]
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1、个位相加，进制后续链表值+1
        ListNode hearPre = new ListNode(-1);
        hearPre.next = new ListNode();
        ListNode listNode = hearPre.next;
        int i = 0;
        while (l1 != null || l2 != null) {
            if (listNode.next == null) {
                listNode.next = new ListNode();
            }
            listNode = listNode.next;
            i=0;
            if (l1 == null) {
                i = l2.val + listNode.val;
            } else if (l2 == null) {
                i = l1.val + listNode.val;
            } else {
                i = l1.val + l2.val + listNode.val;
            }
            if (i > 9) {
                listNode.val = i - 10;
                listNode.next = new ListNode(1);
            } else {
                listNode.val = i;
            }
            if (l1 == null) {
                l2 = l2.next;
            } else if (l2 == null) {
                l1 = l1.next;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return hearPre.next.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);
//        l2.next.next.next.next = new ListNode(9);
        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


}

class ListNode {
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
