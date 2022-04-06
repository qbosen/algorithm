package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//[310] 最小高度树
/* 4,[[1,0],[1,2],[1,3]] */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        Solution solution = new MinimumHeightTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> res = new ArrayList<>();
            if (n == 1) {
                res.add(0);
                return res;
            }
            int[] degree = new int[n];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                degree[edge[0]]++;
                degree[edge[1]]++;
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) queue.offer(i);
            }
            while (!queue.isEmpty()) {
                res.clear();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    res.add(cur);
                    for (int neighbor : graph.get(cur)) {
                        degree[neighbor]--;
                        // 从下往上一层一层剪掉叶子节点
                        if (degree[neighbor] == 1) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}