package top.abosen.leetcode;

import java.util.*;
import top.abosen.leetcode.struct.*;

//[437] 路径总和 III
/* [10,5,-3,3,2,null,11,3,-2,null,1],8 */
public class PathSumIii{
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int ans, t;
        public int pathSum(TreeNode root, int _t) {
            if (root == null) return 0;
            t = _t;
            map.put(0, 1);
            dfs(root, root.val);
            return ans;
        }
        void dfs(TreeNode root, int val) {
            if (map.containsKey(val - t)) ans += map.get(val - t);
            map.put(val, map.getOrDefault(val, 0) + 1);
            if (root.left != null) dfs(root.left, val + root.left.val);
            if (root.right != null) dfs(root.right, val + root.right.val);
            map.put(val, map.getOrDefault(val, 0) - 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}