package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

//[919] 完全二叉树插入器
/* ["CBTInserter","insert","get_root"],[[[1]],[2],[]] */
public class CompleteBinaryTreeInserter {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CBTInserter {
        TreeNode root;
        List<TreeNode> parent;
        List<TreeNode> children;


        public CBTInserter(TreeNode root) {
            this.root = root;
            this.parent = new ArrayList<>();
            this.children = new ArrayList<>();
            this.parent.add(root);
            init();
        }

        private void init() {
            boolean findNull = false;
            while (!findNull) {
                for (TreeNode node : parent) {
                    if (node.left != null) {
                        children.add(node.left);
                    }
                    if (node.right != null) {
                        children.add(node.right);
                    }
                    if (node.left == null || node.right == null) {
                        findNull = true;
                    }
                }

                if (!findNull) {
                    parent = children;
                    children = new ArrayList<>();
                }
            }
        }

        public int insert(int val) {
            if (children.size() == 2 * parent.size()) {
                parent = children;
                children = new ArrayList<>();
            }

            TreeNode parent = this.parent.get(children.size() / 2);
            TreeNode child = new TreeNode(val);
            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            children.add(child);
            return parent.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}