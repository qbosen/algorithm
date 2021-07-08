/*
 * @lc app=leetcode.cn id=930 lang=java
 *
 * [930] 和相同的二元子数组
 *
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/description/
 *
 * algorithms
 * Medium (41.32%)
 * Likes:    129
 * Dislikes: 0
 * Total Accepted:    11.8K
 * Total Submissions: 24.5K
 * Testcase Example:  '[1,0,1,0,1]\n2'
 *
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 
 * 子数组 是数组的一段连续部分。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * nums[i] 不是 0 就是 1
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        // 记录扫描过的 sum[i] 的出现次数
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int sr = sum[i + 1], sl = sr - goal;
            res += cnt.getOrDefault(sl, 0);
            cnt.put(sr, cnt.getOrDefault(sr, 0) + 1); // 记录扫描过的sum[r]
        }
        return res;
    }
}
// @lc code=end

