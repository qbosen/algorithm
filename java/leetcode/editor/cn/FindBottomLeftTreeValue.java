package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

//[513] 找树左下角的值
/* [2,1,3] */
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int maxLevel = 0;
        int maxLevelValue = 0;

        public int findBottomLeftValue(TreeNode root) {
            findWithLevel(root, 1);
            return maxLevelValue;
        }

        private void findWithLevel(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            if (level > maxLevel) {
                maxLevel = level;
                maxLevelValue = node.val;
            }
            findWithLevel(node.left, level + 1);
            findWithLevel(node.right, level + 1);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}