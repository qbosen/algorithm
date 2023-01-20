package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//[1817] 查找用户活跃分钟数
/* [[0,5],[1,2],[0,2],[0,5],[1,3]],5 */
public class FindingTheUsersActiveMinutes {
    public static void main(String[] args) {
        Solution solution = new FindingTheUsersActiveMinutes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            Map<Integer, Set<Integer>> activeMinutes = new HashMap<>();
            for (int[] log : logs) {
                int id = log[0], time = log[1];
                activeMinutes.putIfAbsent(id, new HashSet<>());
                activeMinutes.get(id).add(time);
            }
            int[] answer = new int[k];
            for (Set<Integer> minutes : activeMinutes.values()) {
                int activeCount = minutes.size();
                answer[activeCount - 1]++;
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}