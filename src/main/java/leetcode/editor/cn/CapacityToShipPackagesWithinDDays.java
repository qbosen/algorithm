package leetcode.editor.cn;

//1011 在 D 天内送达包裹的能力
/* [1,2,3,4,5,6,7,8,9,10],5 */
public class CapacityToShipPackagesWithinDDays {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int left = 0;
            int right = 0;
            for (int weight : weights) {
                if (weight > left) {
                    left = weight;
                }
                right += weight;
            }

            while (left < right) {
                int mid = (left + right) / 2;
                int days = 1;
                int cur = 0;

                for (int weight : weights) {
                    if (cur + weight > mid) {
                        days++;
                        cur = 0;
                    }
                    cur += weight;
                }
                if (days <= D) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}