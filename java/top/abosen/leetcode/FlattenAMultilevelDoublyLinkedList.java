package top.abosen.leetcode;

//[430] 扁平化多级双向链表
/* [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12] */
public class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenAMultilevelDoublyLinkedList().new Solution();
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public Node flatten(Node head) {
            dfs(head);
            return head;
        }

        public Node dfs(Node node) {
            Node cur = node;
            // 记录链表的最后一个节点
            Node last = null;

            while (cur != null) {
                Node next = cur.next;
                //  如果有子节点，那么首先处理子节点
                if (cur.child != null) {
                    Node childLast = dfs(cur.child);

                    next = cur.next;
                    //  将 node 与 child 相连
                    cur.next = cur.child;
                    cur.child.prev = cur;

                    //  如果 next 不为空，就将 last 与 next 相连
                    if (next != null) {
                        childLast.next = next;
                        next.prev = childLast;
                    }

                    // 将 child 置为空
                    cur.child = null;
                    last = childLast;
                } else {
                    last = cur;
                }
                cur = next;
            }
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}