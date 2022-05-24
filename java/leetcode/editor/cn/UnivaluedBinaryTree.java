package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

//[965] 单值二叉树
/* [1,1,1,1,1,null,1] */
public class UnivaluedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new UnivaluedBinaryTree().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            return (root.left == null || (root.left.val == root.val && isUnivalTree(root.left))) &&
                    (root.right == null || (root.right.val == root.val && isUnivalTree(root.right)));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}