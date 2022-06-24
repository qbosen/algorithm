package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//[515] 在每个树行中找最大值
/* [1,3,2,5,3,null,9] */
public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
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
        public List<Integer> largestValues(TreeNode root) {
            if (root == null) return Collections.emptyList();
            var result = new ArrayList<Integer>();
            var deque = new ArrayDeque<TreeNode>();
            deque.add(root);

            while (!deque.isEmpty()) {
                int size = deque.size();
                int max = Integer.MIN_VALUE;

                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.pop();
                    if (node.val > max) max = node.val;
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                }
                result.add(max);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}