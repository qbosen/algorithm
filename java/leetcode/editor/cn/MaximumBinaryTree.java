package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

//[654] 最大二叉树
/* [3,2,1,6,0,5] */
public class MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTree().new Solution();
        solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return recursive(nums, 0, nums.length-1);
        }

        public TreeNode recursive(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int idx = start;
            for (int i = start + 1; i <= end; ++i) {
                if (nums[i] > nums[idx]) {
                    idx = i;
                }
            }
            var root = new TreeNode(nums[idx]);
            root.left = recursive(nums, start, idx - 1);
            root.right = recursive(nums, idx + 1, end);
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}