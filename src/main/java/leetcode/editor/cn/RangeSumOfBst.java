package leetcode.editor.cn;

// 938 二叉搜索树的范围和
/* [10,5,15,3,7,null,18],7,15 */

public class RangeSumOfBst {
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
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }

            if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            }
            if (root.val < low) {
                return rangeSumBST(root.right, low, high);
            }

            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}

