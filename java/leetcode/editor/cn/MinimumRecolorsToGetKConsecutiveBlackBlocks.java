package leetcode.editor.cn;

//[2379] 得到 K 个黑块的最少涂色次数
/* "WBBWWBBWBW",7 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static void main(String[] args) {
        Solution solution = new MinimumRecolorsToGetKConsecutiveBlackBlocks().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            // maintain white blocks
            int count = 0;
            for (int i = 0; i < k; i++) {
                if (blocks.charAt(i) == 'W')
                    count++;
            }
            int res = count;

            for (int i = k; i < blocks.length(); i++) {
                if(blocks.charAt(i-k) == 'W') count--;
                if(blocks.charAt(i) == 'W') count++;
                res = Math.min(res, count);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}