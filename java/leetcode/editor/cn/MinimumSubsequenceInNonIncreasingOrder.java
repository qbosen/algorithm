package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1403] 非递增顺序的最小子序列
/* [4,3,10,9,8] */
public class MinimumSubsequenceInNonIncreasingOrder{
    public static void main(String[] args) {
        Solution solution = new MinimumSubsequenceInNonIncreasingOrder().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0, cur = 0, idx = nums.length - 1;
        for (int i : nums) sum += i;
        List<Integer> ans = new ArrayList<>();
        while (cur <= sum) {
            sum -= nums[idx];
            cur += nums[idx];
            ans.add(nums[idx--]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}