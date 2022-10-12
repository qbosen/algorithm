package leetcode.editor.cn;

import leetcode.editor.cn.struct.ListNode;

import java.util.HashSet;
import java.util.Set;

//[817] 链表组件
/* [0,1,2,3],[0,1,3] */
public class LinkedListComponents {
    public static void main(String[] args) {
        Solution solution = new LinkedListComponents().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public int numComponents(ListNode head, int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            ListNode node = head;

            int count = 0, component = 0;
            while (node != null) {
                if (set.contains(node.val)) {
                    count++;
                } else {
                    if (count > 0) component++;
                    count = 0;
                }
                node = node.next;
            }

            if (count > 0) component++;
            return component;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}