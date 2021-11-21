package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[559] N 叉树的最大深度
/* [1,null,3,2,4,null,5,6] */
public class MaximumDepthOfNAryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfNAryTree().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int maxDepth(Node root) {
            return dfs(root);
        }

        int bfs(Node root) {
            if (root == null) {
                return 0;
            }

            int ans = 0;
            Deque<Node> deque = new ArrayDeque<>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                ans++;
                int l = deque.size();
                for (int i = 0; i < l; i++) {
                    Node node = deque.pollFirst();
                    if (node != null && node.children != null) {
                        deque.addAll(node.children);
                    }
                }
            }
            return ans;
        }

        int dfs(Node root) {
            if (root == null) return 0;
            int ans = 0;
            for (Node node : root.children) {
                ans = Math.max(ans, dfs(node));
            }
            return ans + 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}