package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayDeque;

//[623] 在二叉树中增加一行
/* [4,2,6,3,1,5],1,2 */
public class AddOneRowToTree {
    public static void main(String[] args) {
        Solution solution = new AddOneRowToTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            var dummy = new TreeNode(-1);
            dummy.left = root;

            var queue = new ArrayDeque<TreeNode>();
            queue.addLast(dummy);

            int level = 0;
            while (!queue.isEmpty()) {
                if (level== depth -1) {
                    var s = queue.size();
                    for (int i = 0; i < s; i++) {
                        var node = queue.pollFirst();
                        assert node != null;
                        var left = node.left;
                        var right = node.right;
                        node.left = new TreeNode(val);
                        node.left.left = left;
                        node.right = new TreeNode(val);
                        node.right.right = right;
                    }
                    break;
                }

                var s = queue.size();
                for (int i = 0; i < s; i++) {
                    var node = queue.pollFirst();
                    assert node != null;
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                }
                level++;
            }

            return dummy.left;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}