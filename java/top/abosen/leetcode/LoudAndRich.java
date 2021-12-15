package top.abosen.leetcode;

import java.util.*;
import top.abosen.leetcode.struct.*;

//[851] 喧闹和富有
/* [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]],[3,2,5,4,6,1,7,0] */
public class LoudAndRich{
    public static void main(String[] args) {
        Solution solution = new LoudAndRich().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        // richer than me
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] rich : richer) {
            graph[rich[1]].add(rich[0]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            dfs(i, quiet, graph, ans);
        }
        return ans;
    }

    private void dfs(int i, int[] quiet, List<Integer>[] graph, int[] ans) {
        if (ans[i] != -1) {
            return ;
        }
        ans[i] = i;
        for (int j : graph[i]) {
            dfs(j, quiet, graph, ans);
            if (quiet[ans[j]] < quiet[ans[i]]) {
                ans[i] = ans[j];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}