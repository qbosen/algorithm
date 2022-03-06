package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[2100] 适合打劫银行的日子
/* [5,3,3,3,5,6,2],2 */
public class FindGoodDaysToRobTheBank {
    public static void main(String[] args) {
        Solution solution = new FindGoodDaysToRobTheBank().new Solution();
        System.out.println(solution.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            int n = security.length;
            int[] left = new int[n], right = new int[n];
            for (int i = 1; i < n; i++) {
                left[i] = security[i] <= security[i - 1] ? left[i - 1] + 1 : 0;
            }

            for (int i = n - 2; i >= 0; i--) {
                right[i] = security[i] <= security[i + 1] ? right[i + 1] + 1 : 0;
            }

            List<Integer> res = new ArrayList<>();
            for (int i = time; i < n - time; i++) {
                if (left[i] >= time && right[i] >= time) {
                    res.add(i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}