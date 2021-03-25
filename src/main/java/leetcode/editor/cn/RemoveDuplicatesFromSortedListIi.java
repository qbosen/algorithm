package leetcode.editor.cn;

//82 删除排序链表中的重复元素 II
/* [1,2,3,3,4,4,5] */
public class RemoveDuplicatesFromSortedListIi {
    private class ListNode {
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;

            ListNode current = head;
            ListNode prev = dummy;
            while (current != null) {   // first different value node
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }

                if (prev.next != current) {
                    // meet same value node, skip them and keep prev invariant
                    prev.next = current.next;
                }else{
                    prev = current;
                }

                current = current.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}