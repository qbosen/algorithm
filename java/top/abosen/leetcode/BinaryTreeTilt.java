package top.abosen.leetcode;

import top.abosen.leetcode.struct.TreeNode;

//[563] 二叉树的坡度
/* [1,2,3] */
public class BinaryTreeTilt {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeTilt().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        int ans = 0;

        public int findTilt(TreeNode root) {
            ans = 0;
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int sl = dfs(node.left);
            int sr = dfs(node.right);
            ans += Math.abs(sl - sr);
            return sl + sr + node.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}