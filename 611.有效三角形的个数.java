import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=611 lang=java
 *
 * [611] 有效三角形的个数
 *
 * https://leetcode-cn.com/problems/valid-triangle-number/description/
 *
 * algorithms
 * Medium (48.64%)
 * Likes:    251
 * Dislikes: 0
 * Total Accepted:    34.6K
 * Total Submissions: 66.2K
 * Testcase Example:  '[2,2,3,4]'
 *
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是: 
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 
 * 
 * 注意:
 * 
 * 
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (nums == null || n < 3)
            return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 查找 i+2 ... n-1 范围内 < (n[i]+n[j]) 的索引
                int idx = bs(nums, j + 1, n - 1, nums[i] + nums[j]);
                if (idx != -1) {
                    count += idx - j;
                }
            }
        }
        return count;
    }

    public static int bs(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                if (mid == nums.length - 1 || (nums[mid + 1] >= target)) {
                    return mid;
                }
                l = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end
