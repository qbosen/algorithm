import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        dfs(list1, root1);
        dfs(list2, root2);
        return list1.equals(list2);
    }

    private void dfs(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            list.add(node.val);
        } else {
            if (node.left != null) {
                dfs(list, node.left);
            }
            if (node.right != null) {
                dfs(list, node.right);
            }
        }
    }
}
// @lc code=end
