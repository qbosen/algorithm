package leetcode.editor.cn;

//[875] 爱吃香蕉的珂珂
/* [3,6,7,11],8 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
        solution.minEatingSpeed(new int[]{312884470}, 968709470);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int sum = 0, max = piles[0];
            for (int pile : piles) {
                sum += pile;
                max = Math.max(max, pile);
            }
            int l = Math.max(sum / h, 1), r = max;
            while (l < r) {
                int m = l + (r - l) / 2;
                int sp = spendTime(piles, m);
                if (sp > h) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return l;
        }

        private int spendTime(int[] piles, int k) {
            int h = 0;
            for (int pile : piles) {
                h += (pile + k - 1) / k;
            }
            return h;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}