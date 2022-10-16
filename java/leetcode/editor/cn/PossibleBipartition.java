package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[886] 可能的二分法
/* 4,[[1,2],[1,3],[2,4]] */
public class PossibleBipartition{
    public static void main(String[] args) {
        Solution solution = new PossibleBipartition().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] group = new List[n+1];
        int[] color = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            group[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            group[dislike[0]].add(dislike[1]);
            group[dislike[1]].add(dislike[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(i, 1, color, group)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, int nc, int[] color, List<Integer>[] group) {
        color[i] = nc;
        for (int next : group[i]) {
            if (color[next] != 0 && color[next] == nc) {
                return false;
            }
            if (color[next] == 0 && !dfs(next, nc == 1 ? 2 : 1, color, group)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}