package leetcode.editor.cn;

// 897 递增顺序搜索树
/* [5,3,6,2,4,null,8,1,null,null,null,7,9] */

public class IncreasingOrderSearchTree {

    protected static class TreeNode {
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
        private TreeNode resNode;
        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummy = new TreeNode();
            resNode = dummy;
            inorder(root);
            return dummy.right;
        }

        private void inorder(TreeNode node) {
            if (node == null) {
                return;
            }
            inorder(node.left);

            resNode.right = node;
            node.left = null;
            resNode = node;

            inorder(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}