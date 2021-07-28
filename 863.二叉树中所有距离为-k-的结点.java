import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
 *
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/description/
 *
 * algorithms
 * Medium (54.86%)
 * Likes:    385
 * Dislikes: 0
 * Total Accepted:    29.4K
 * Total Submissions: 49.3K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n2'
 *
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * 
 * 
 * 
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            if (node.left != null) {
                map.put(node.left.val, node);
                deque.addFirst(node.left);
            }
            if (node.right != null) {
                map.put(node.right.val, node);
                deque.addFirst(node.right);
            }
        }

        List<Integer> result = new ArrayList<>();
        findAns(target, null, 0, k, result, map);
        return result;
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k, List<Integer> result,
            Map<Integer, TreeNode> parent) {
        if (node == null)
            return;
        if (depth == k) {
            result.add(node.val);
            return;
        }

        if (node.left != from) {
            findAns(node.left, node, depth + 1, k, result, parent);
        }
        if (node.right != from) {
            findAns(node.right, node, depth + 1, k, result, parent);
        }
        if (parent.get(node.val) != from) {
            findAns(parent.get(node.val), node, depth + 1, k, result, parent);
        }
    }

}
// @lc code=end
