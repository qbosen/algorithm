package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

//[606] 根据二叉树创建字符串
/* [1,2,3,4] */
public class ConstructStringFromBinaryTree{
    public static void main(String[] args) {
        Solution solution = new ConstructStringFromBinaryTree().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.substring(1, sb.length() - 1);
    }

    private void dfs(TreeNode node) {
        sb.append('(').append(node.val);
        if (node.left != null) {
            dfs(node.left);
        } else if (node.right != null) {
            // left空,right非空
            sb.append("()");
        }

        if (node.right != null) {
            dfs(node.right);
        }
        sb.append(')');
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}