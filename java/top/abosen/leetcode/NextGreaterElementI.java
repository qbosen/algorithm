package top.abosen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

//[496] 下一个更大元素 I
/* [4,1,2],[1,3,4,2] */
public class NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();
            Deque<Integer> stack = new ArrayDeque<>();
            for (int cur : nums2) {
                while (!stack.isEmpty() && stack.peek() < cur) {
                    int pop = stack.pop();
                    map.put(pop, cur);
                }
                stack.push(cur);
            }
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = map.getOrDefault(nums1[i], -1);
            }
            return nums1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}