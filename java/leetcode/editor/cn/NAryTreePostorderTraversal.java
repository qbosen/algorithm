package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[590] N 叉树的后序遍历
/* [1,null,3,2,4,null,5,6] */
public class NAryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        while (!deque.isEmpty()) {
            Node node = deque.pollFirst();
            res.add(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    // 子节点压进去后变成右到左
                    deque.offerFirst(child);
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}