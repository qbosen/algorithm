package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[653] 两数之和 IV - 输入 BST
/* [5,3,6,2,4,null,7],9 */
public class TwoSumIvInputIsABst {
    public static void main(String[] args) {
        Solution solution = new TwoSumIvInputIsABst().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            HashSet<Integer> lookUp = new HashSet<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (lookUp.contains(node.val)) {
                    return true;
                }
                lookUp.add(k - node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}