package leetcode.editor.cn;

import java.util.*;

//[433] 最小基因变化
/* "AACCGGTT","AACCGGTA",["AACCGGTA"] */
public class MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new MinimumGeneticMutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            Set<String> cnt = new HashSet<String>();
            Set<String> visited = new HashSet<String>();
            char[] keys = {'A', 'C', 'G', 'T'};
            Collections.addAll(cnt, bank);
            if (start.equals(end)) {
                return 0;
            }
            if (!cnt.contains(end)) {
                return -1;
            }
            Queue<String> queue = new ArrayDeque<>();
            queue.offer(start);
            visited.add(start);
            int step = 1;
            while (!queue.isEmpty()) {
                int sz = queue.size();
                for (int i = 0; i < sz; i++) {
                    String curr = queue.poll();
                    for (int j = 0; j < 8; j++) {
                        for (int k = 0; k < 4; k++) {
                            assert curr != null;
                            if (keys[k] != curr.charAt(j)) {
                                StringBuilder sb = new StringBuilder(curr);
                                sb.setCharAt(j, keys[k]);
                                String next = sb.toString();
                                if (!visited.contains(next) && cnt.contains(next)) {
                                    if (next.equals(end)) {
                                        return step;
                                    }
                                    queue.offer(next);
                                    visited.add(next);
                                }
                            }
                        }
                    }
                }
                step++;
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}