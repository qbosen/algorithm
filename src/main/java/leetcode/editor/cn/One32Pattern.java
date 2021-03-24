package leetcode.editor.cn;

// 456 132 模式
/* [1,2,3,4] */

import java.util.Deque;
import java.util.LinkedList;

public class One32Pattern {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            Deque<Integer> stack = new LinkedList<>();
            int k = Integer.MIN_VALUE;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] < k) return true;
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    // 3,2 找到了
                    k = Math.max(stack.pop(), k);
                }
                stack.push(nums[i]);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}