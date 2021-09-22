package top.abosen.leetcode;

import top.abosen.leetcode.struct.ListNode;

import java.util.Arrays;

//[725] 分隔链表
/* [1,2,3],5 */
public class SplitLinkedListInParts {
    public static void main(String[] args) {
        Solution solution = new SplitLinkedListInParts().new Solution();
        System.out.println(Arrays.toString(solution.splitListToParts(ListNode.from(0,1,2,3,4), 3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public ListNode[] splitListToParts(ListNode head, int k) {
            int len = 0;
            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
                len++;
            }
            int reminder = len % k;
            int least = len / k;

            ListNode[] ans = new ListNode[k];
            cur = head;
            int i = 0;
            int j = 0;
            while (i < len && j < k) {
                // 当前元素长度
                int count = least + (j < reminder ? 1 : 0);
                if (count == 0) {
                    break;
                }
                ans[j] = cur;
                ListNode prev = null;
                while (count > 0) {
                    prev = cur;
                    cur = cur.next;
                    count--;
                    i++;
                }
                if (prev != null) {
                    prev.next = null;
                }
                j++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}