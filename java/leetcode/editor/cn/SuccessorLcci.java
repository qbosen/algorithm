package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

//[面试题 04.06] 后继者
/* [2,1,3],1 */
public class SuccessorLcci {
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null) return null;
            if (root.val <= p.val) return inorderSuccessor(root.right, p);
            TreeNode ans = inorderSuccessor(root.left, p);
            return ans == null ? root : ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}