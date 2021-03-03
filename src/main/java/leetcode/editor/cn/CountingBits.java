package leetcode.editor.cn;

//338 比特位计数
/* 2 */
public class CountingBits {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countBits(int num) {
            int[] res = new int[num + 1];
            for (int i = 1; i < res.length; i++) {
                res[i] = 1 + res[i & (i - 1)];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}