package leetcode.editor.cn;

// 61 旋转链表
/* [1,2,3,4,5],2 */

public class RotateList {
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
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;

            ListNode current = head;
            int n = 1;
            while (current.next != null) {
                current = current.next;
                n++;
            }
            current.next = head;

            int i = n- k % n;


            while(i > 0 ){
                current = current.next;
                i--;
            }

            ListNode h = current.next;
            current.next = null;
            return h;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}