package leetcode.editor.cn;

//783 二叉搜索树节点最小距离
/* [4,2,6,1,3] */
public class MinimumDistanceBetweenBstNodes {
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
    class Solution {
        int ans;
        int prev;

        public int minDiffInBST(TreeNode root) {
            ans = Integer.MAX_VALUE;
            prev = -1;
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode node) {
            if (node == null) return;
            dfs(node.left);
            if (prev != -1) {
                ans = Math.min(ans, node.val - prev);
            }
            prev = node.val;

            dfs(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}