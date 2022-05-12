package leetcode.editor.cn;

//[944] 删列造序
/* ["cba","daf","ghi"] */
public class DeleteColumnsToMakeSorted {
    public static void main(String[] args) {
        Solution solution = new DeleteColumnsToMakeSorted().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDeletionSize(String[] strs) {
            int n = strs.length;
            int m = strs[0].length();
            int res = 0;
            for (int col = 0; col < m; col++) {
                char prev = strs[0].charAt(col);
                for (int row = 1; row < n; row++) {
                    char cur = strs[row].charAt(col);
                    if (cur < prev) {
                        res++;
                        break;
                    }
                    prev = cur;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}