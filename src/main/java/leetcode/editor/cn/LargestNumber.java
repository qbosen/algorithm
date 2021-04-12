package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//179 最大数
/* [10,2] */
public class LargestNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = String.valueOf(nums[i]);
            }
            Comparator<String> comparator = (o1, o2) -> (o1 + o2).compareTo(o2 + o1);
            Arrays.sort(strs, comparator.reversed());
            StringBuilder builder = new StringBuilder();
            for (String str : strs) {
                builder.append(str);
            }
            if (builder.charAt(0) == '0') return "0";
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}