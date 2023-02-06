package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[2331] 计算布尔二叉树的值
/* [2,1,3,null,null,0,1] */
public class EvaluateBooleanBinaryTree{
    public static void main(String[] args) {
        Solution solution = new EvaluateBooleanBinaryTree().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 0) return false;
        if(root.val == 1) return true;

        if (root.val==2) return evaluateTree(root.left) || evaluateTree(root.right);
        if(root.val == 3) return evaluateTree(root.left) && evaluateTree(root.right);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}