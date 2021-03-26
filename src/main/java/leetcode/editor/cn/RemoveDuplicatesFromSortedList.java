package leetcode.editor.cn;
//83 删除排序链表中的重复元素
/* [1,1,2] */
public class RemoveDuplicatesFromSortedList{

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current!=null){
            if(prev!=null && current.val == prev.val){
                prev.next = current.next;
            }else{
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}