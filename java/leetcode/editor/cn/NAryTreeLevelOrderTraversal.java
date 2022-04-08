package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[429] N 叉树的层序遍历
/* [1,null,3,2,4,null,5,6] */
public class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) return ans;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    level.add(node.val);
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
                ans.add(level);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}