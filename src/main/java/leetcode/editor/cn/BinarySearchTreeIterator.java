package leetcode.editor.cn;

// 173 二叉搜索树迭代器
/* ["BSTIterator","next","next","hasNext","next","hasNext","next","hasNext","next","hasNext"],[[[7,3,15,null,null,9,20]],[],[],[],[],[],[],[],[],[]] */

import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTreeIterator {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class BSTIterator {
        Deque<TreeNode> stack;

        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            pushLeft(root);
        }

        public int next() {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                pushLeft(cur.right);
            }
            return cur.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}