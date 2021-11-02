package top.abosen.leetcode;

import java.util.*;
import top.abosen.leetcode.struct.*;

//[237] 删除链表中的节点
/* [4,5,1,9],5 */
public class DeleteNodeInALinkedList{
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInALinkedList().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}