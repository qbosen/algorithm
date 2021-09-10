package top.abosen.leetcode;

//1894 找到需要补充粉笔的学生编号
/* [5,1,5],22 */
public class FindTheStudentThatWillReplaceTheChalk {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            int n = chalk.length;
            if (chalk[0] > k) return 0;
            for (int i = 1; i < n; i++) {
                chalk[i] += chalk[i - 1] ;
                if (chalk[i] > k) {
                    return i;
                }
            }

            k = k % chalk[n - 1];
            int l = 0, r = n - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (chalk[m] <= k) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return l;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
    }
}