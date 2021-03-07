package leetcode.editor.cn;

// 496 下一个更大元素 I
/* [4,1,2],[1,3,4,2] */

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreaterElementI {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < nums2.length; i++) {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    map.put(nums2[stack.pop()], nums2[i]);
                }
                stack.push(i);
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.getOrDefault(nums1[i], -1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}