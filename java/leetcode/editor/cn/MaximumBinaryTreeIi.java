package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

//[998] 最大二叉树 II
/* [4,1,3,null,null,2],5 */
public class MaximumBinaryTreeIi {
    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTreeIi().new Solution();
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
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            TreeNode dummy = new TreeNode(-1);
            dummy.right = root;

            dfs(dummy, root, val);
            return dummy.right;
        }

        private void dfs(TreeNode prev, TreeNode cur, int val) {
            if (cur == null) {
                prev.right = new TreeNode(val);
            } else if (cur.val < val) {
                TreeNode node = new TreeNode(val);
                node.left = cur;
                prev.right = node;
            } else {
                dfs(cur, cur.right, val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}