package leetcode.editor.cn;

// 503 下一个更大元素 II
/* [1,2,1] */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElementIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Deque<Integer> stack = new LinkedList<>();
            int[] res = new int[nums.length];
            Arrays.fill(res, -1);
            for (int i = nums.length * 2 - 1; i >= 0; i--) {
                int current = i % nums.length;
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[current]) {
                    stack.pop();
                }
                res[current] = stack.isEmpty() ? -1 : nums[stack.peek()];
                stack.push(current);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}