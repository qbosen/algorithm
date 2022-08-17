package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Objects;

//[1302] 层数最深叶子节点的和
/* [1,2,3,4,5,null,6,7,null,null,null,null,8] */
public class DeepestLeavesSum{
    public static void main(String[] args) {
        Solution solution = new DeepestLeavesSum().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        var queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);
        int levelSum = 0;
        while (!queue.isEmpty()) {
            var size = queue.size();
            levelSum = 0;
            for (int i = 0; i < size; i++) {
                var node = queue.pollFirst();
                levelSum += Objects.requireNonNull(node).val;
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return levelSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}