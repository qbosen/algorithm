package leetcode.editor.cn;
// 二叉树的右视图
// 199
// [1,2,3,null,5,null,4]

import struct.TreeNode;
import util.IntUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void run(Solution solution, String expect, String root) {
        TreeNode root_ = IntUtil.parse1DInt2TreeNode(root);
        List<Integer> result = solution.rightSideView(root_);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        run(solution, "[1,3,4]", "[1,2,3,null,5,null,4]");
        run(solution, "[3,4,2]", "[3,1,4,null,null,2]");
        run(solution, "[3,1,2]", "[3,1,null,null,2]");
        run(solution, "[5,6,4,1]", "[5,3,6,2,4,null,null,1]");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return Collections.emptyList();
            LinkedHashMap<Integer, Integer> listMap = new LinkedHashMap<>();
            inorderTravel(root, listMap, 0);
            return new ArrayList<>(listMap.values());
        }

        private void inorderTravel(TreeNode node, LinkedHashMap<Integer, Integer> listMap, int level) {
            if (node == null) return;
            listMap.put(level, node.val);
            inorderTravel(node.left, listMap, level + 1);
            inorderTravel(node.right, listMap, level + 1);
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}