package leetcode.editor.cn;

//92 反转链表 II
/* [1,2,3,4,5],2,4 */
public class ReverseLinkedListIi {
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 哨兵 解决left=1和left>1时，头节点的不同处理
            ListNode dummy = new ListNode();
            dummy.next = head;

            ListNode prev = dummy;
            ListNode current = head;
            int idx = 1;

            ListNode a, b, c, d;

            while (current != null) {
                if (idx == left) {
                    a = prev;
                    b = current;
                    while (idx <= right) {
                        ListNode next = current.next;
                        current.next = prev;
                        prev = current;
                        current = next;
                        idx++;
                    }
                    c = prev;
                    d = current;
                    // 穿针引线
                    a.next = c;
                    b.next = d;
                }
                if (current != null) {
                    prev = current;
                    current = current.next;
                    idx++;
                }
            }

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}