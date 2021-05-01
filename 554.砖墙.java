import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=554 lang=java
 *
 * [554] 砖墙
 */

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (List<Integer> row : wall) {
            int idx = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                idx += row.get(i);
                cnt.compute(idx, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        int maxEdge = 0;
        for (Map.Entry<Integer,Integer> entry : cnt.entrySet()) {
            if(entry.getValue() > maxEdge){
                maxEdge = entry.getValue();
            }    
        }
        return wall.size() - maxEdge;
    }
}
// @lc code=end
