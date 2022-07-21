package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

//[814] 二叉树剪枝
/* [1,null,0,0,1] */
public class BinaryTreePruning {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePruning().new Solution();
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
        public TreeNode pruneTree(TreeNode root) {
            if (doPrune(root)) {
                return null;
            }
            return root;
        }

        public boolean doPrune(TreeNode node) {
            boolean pruneLeft = true, pruneRight = true;
            if (node.left != null) {
                pruneLeft = doPrune(node.left);
                if (pruneLeft) {
                    node.left = null;
                }
            }
            if (node.right != null) {
                pruneRight = doPrune(node.right);
                if (pruneRight) {
                    node.right = null;
                }
            }
            return pruneLeft && pruneRight && node.val == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}