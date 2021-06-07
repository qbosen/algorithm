import java.util.Map;

/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int counter = 0;
        map.put(0, -1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            counter += nums[i]==1?1:-1;
            if(map.containsKey(counter)){
                res = Math.max(res, i-map.get(counter));
            }else{
                map.put(counter, i);
            }
        }
        return res;
    }
}
// @lc code=end
