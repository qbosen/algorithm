package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//[652] 寻找重复的子树
/* [1,2,3,4,null,2,4,null,null,4] */
public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
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
        Map<String, Integer> map = new HashMap();
        List<TreeNode> result = new ArrayList();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            dfs(root);
            return result;
        }

        public String dfs(TreeNode node) {
            if (node == null) return "";
            String key = node.val + "," + dfs(node.left) + "," + dfs(node.right);
            if (map.getOrDefault(key, 0) == 1) result.add(node);
            map.put(key, map.getOrDefault(key, 0) + 1);
            return key;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}