package top.abosen.leetcode.struct;

/**
 * @author qiubaisen
 * @date 2021/9/22
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode from(int... ints) {
        if (ints == null || ints.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int anInt : ints) {
            cur.next = new ListNode(anInt);
            cur = cur.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }
}
