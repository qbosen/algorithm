package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[589] N 叉树的前序遍历
/* [1,null,3,2,4,null,5,6] */
public class NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public List<Integer> preorder(Node root) {
//            return dfs(root);
            return iterate(root);
        }

        public List<Integer> dfs(Node root) {
            List<Integer> res = new ArrayList<>();
            _dfs(root, res);
            return res;
        }

        private void _dfs(Node node, List<Integer> res) {
            if (node == null) return;
            res.add(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    _dfs(child, res);
                }
            }
        }

        private List<Integer> iterate(Node root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Deque<Node> deque = new ArrayDeque<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                Node node = deque.pollFirst();
                res.add(node.val);
                if (node.children != null) {
                    List<Node> children = node.children;
                    for (int i = children.size() - 1; i >= 0; i--) {
                        Node child = children.get(i);
                        deque.offerFirst(child);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}