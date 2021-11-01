package top.abosen.leetcode;

import java.util.HashSet;
import java.util.Set;

//[575] 分糖果
/* [1,1,2,2,3,3] */
public class DistributeCandies {
    public static void main(String[] args) {
        Solution solution = new DistributeCandies().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distributeCandies(int[] candyType) {
            Set<Integer> set = new HashSet<>();
            for (int i : candyType) {
                set.add(i);
            }
            return Math.min(set.size(), candyType.length / 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}