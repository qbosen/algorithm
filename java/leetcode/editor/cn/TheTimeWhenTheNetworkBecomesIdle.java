package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[2039] 网络空闲的时刻
/* [[0,1],[1,2]],[0,2,1] */
public class TheTimeWhenTheNetworkBecomesIdle {
    public static void main(String[] args) {
        Solution solution = new TheTimeWhenTheNetworkBecomesIdle().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int networkBecomesIdle(int[][] edges, int[] patience) {
            int n = patience.length;
            int[] distance = new int[n];
            Arrays.fill(distance, -1);

            List<Integer>[] neighbor = new List[n];
            for (int i = 0; i < n; i++){
                neighbor[i] = new ArrayList<>();
            }

            for (int[] i : edges) {
                neighbor[i[0]].add(i[1]);
                neighbor[i[1]].add(i[0]);
            }

            int depth = 0;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(0);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cur = queue.pollFirst();
                    if (distance[cur] != -1) continue;
                    distance[cur] = depth;
                    for (int j : neighbor[cur]){
                        queue.offerLast(j);
                    }
                }
                depth++;
            }


            int max = 0;
            for (int i = 1; i < n; i++) {
                int round = distance[i] * 2;
                int last = ((round - 1) / patience[i]) * patience[i];
                max = Math.max(max, last + round);
            }

            return max + 1;

        }
    }


//leetcode submit region end(Prohibit modification and deletion)
    //

}