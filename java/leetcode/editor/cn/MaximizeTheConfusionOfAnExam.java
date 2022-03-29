package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[2024] 考试的最大困扰度
/* "TTFF",2 */
public class MaximizeTheConfusionOfAnExam {
    public static void main(String[] args) {
        Solution solution = new MaximizeTheConfusionOfAnExam().new Solution();
        System.out.println(solution.maxConsecutiveAnswers("TTFF", 2));
        System.out.println(solution.maxConsecutiveAnswers("TFFT", 1));
        System.out.println(solution.maxConsecutiveAnswers("TTFTTFTT", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            int i = 0, j = 0;
            int res = 0;
            int tc = 0, fc = 0;

            char[] chars = answerKey.toCharArray();
            int n = chars.length;
            while (j < n) {
                while (j < n && Math.min(tc, fc) <= k) {
                    if (chars[j] == 'T') {
                        tc++;
                    } else {
                        fc++;
                    }
                    j++;
                }
                // 跳出循环 可能是右边界 无效(超出k次操作) 或 到了边缘
                int len = Math.min(tc, fc) <= k ? j - i : j - 1 - i;
                res = Math.max(res, len);
                if (j == n) return res;
                // 移动左边界
                if (chars[i] == 'T') {
                    tc--;
                } else {
                    fc--;
                }
                i++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}