package top.abosen.leetcode;

import java.util.concurrent.ThreadLocalRandom;

//[384] 打乱数组
/* ["Solution","shuffle","reset","shuffle"],[[[1,2,3]],[],[],[]] */
public class ShuffleAnArray {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] origin;
        int[] arr;

        public Solution(int[] nums) {
            this.origin = nums;
            this.arr = new int[origin.length];
            System.arraycopy(origin, 0, arr, 0, origin.length);
        }

        public int[] reset() {
            return origin;
        }

        public int[] shuffle() {
            for (int i = arr.length - 1; i >= 0; i--) {
                int idx = ThreadLocalRandom.current().nextInt(i + 1);
                int t = arr[i];
                arr[i] = arr[idx];
                arr[idx] = t;
            }
            return arr;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}