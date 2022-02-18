package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[1791] 找出星型图的中心节点
/* [[1,2],[2,3],[4,2]] */
public class FindCenterOfStarGraph {
    public static void main(String[] args) {
        Solution solution = new FindCenterOfStarGraph().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCenter(int[][] edges) {
            for (int a : edges[0]) {
                for (int b : edges[1]) {
                    if (a == b) return a;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}