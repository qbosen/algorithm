package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[2049] 统计最高分的节点数目
/* [-1,2,0,2,0] */
public class CountNodesWithTheHighestScore {
    public static void main(String[] args) {
        Solution solution = new CountNodesWithTheHighestScore().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        int[][] children;
        long maxScore = 0;
        int res = 0;

        public int countHighestScoreNodes(int[] parents) {
            n = parents.length;
            children = new int[n][2];
            for (int i = 0; i < n; i++) {
                children[i][0] = children[i][1] = -1;
            }
            for (int i = 0; i < n; i++) {
                int p = parents[i];

                if (p != -1) { // 存在父节点
                    if (children[p][0] == -1) {
                        children[p][0] = i;
                    } else {
                        children[p][1] = i;
                    }
                }
            }
            dfs(0);

            return res;
        }

        // 在计算该节点的子节点数的同时，计算并更新得分
        private int dfs(int node) {
            if (node == -1) {
                return 0;
            }
            int l = dfs(children[node][0]);
            int r = dfs(children[node][1]);
            // score 可能越界
            long score = (long) Math.max(l, 1) * Math.max(r, 1) * Math.max(n - l - r - 1, 1);
            if (maxScore == score) {
                res++;
            } else if (maxScore < score) {
                maxScore = score;
                res = 1;
            }
            return l + r + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}