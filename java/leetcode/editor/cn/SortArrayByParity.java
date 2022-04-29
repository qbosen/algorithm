package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[905] 按奇偶排序数组
/* [3,1,2,4] */
public class SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParity().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            int l = 0, r = n - 1;
            for (int num : nums) {
                if (num % 2 == 0) {
                    res[l++] = num;
                } else {
                    res[r--] = num;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}