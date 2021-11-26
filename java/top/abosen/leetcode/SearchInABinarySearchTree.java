package top.abosen.leetcode;

import top.abosen.leetcode.struct.TreeNode;

//[700] 二叉搜索树中的搜索
/* [4,2,7,1,3],2 */
public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;
            else if (val < root.val) return searchBST(root.left, val);
            else if (val > root.val) return searchBST(root.right, val);
            else return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}