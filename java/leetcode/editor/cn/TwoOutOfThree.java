package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//[2032] 至少在两个数组中出现的值
/* [1,1,3,2],[2,3],[3] */
public class TwoOutOfThree {
    public static void main(String[] args) {
        Solution solution = new TwoOutOfThree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            int[] count = new int[101];
            for (int i : nums1) count[i] |= 0b1;
            for (int i : nums2) count[i] |= 0b10;
            for (int i : nums3) count[i] |= 0b100;

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < count.length; i++) {
                if (Integer.bitCount(count[i]) > 1) result.add(i);
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}