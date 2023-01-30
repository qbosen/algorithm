package leetcode.editor.cn;

import leetcode.editor.cn.struct.ListNode;

//[1669] 合并两个链表
/* [0,1,2,3,4,5],3,4,[1000000,1000001,1000002] */
public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {
        Solution solution = new MergeInBetweenLinkedLists().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode head = new ListNode(-1, list1);

            ListNode node = head;
            int index = -1;
            ListNode start = null, end = null;
            while (true) {
                ListNode next = node.next;
                index++;
                if (index == a) {
                    start = node;
                }
                if (index == b) {
                    end = next.next;
                    break;
                }
                node = next;
            }

            start.next = list2;
            node = list2;
            while (node.next != null) {
                node = node.next;
            }
            node.next = end;

            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}