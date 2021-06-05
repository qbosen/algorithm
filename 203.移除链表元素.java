/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            ListNode next = head.next;
            if (head.val == val) {
                prev.next = next;
                head.next = null;
                head = next;
            } else {
                prev = head;
                head = next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end
