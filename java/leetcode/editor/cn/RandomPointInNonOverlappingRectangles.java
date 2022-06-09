package leetcode.editor.cn;

import java.util.Random;

//[497] 非重叠矩形中的随机点
/* ["Solution","pick","pick","pick","pick","pick"],[[[[-2,-2,1,1],[2,2,4,6]]],[],[],[],[],[]] */
public class RandomPointInNonOverlappingRectangles {
    public static void main(String[] args) {
//        Solution solution = new RandomPointInNonOverlappingRectangles().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] rs;
        int[] sum;
        int n;
        Random random = new Random();
        public Solution(int[][] rects) {
            rs = rects;
            n = rs.length;
            sum = new int[n + 1];
            for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + (rs[i - 1][2] - rs[i - 1][0] + 1) * (rs[i - 1][3] - rs[i - 1][1] + 1);
        }
        public int[] pick() {
            int val = random.nextInt(sum[n]) + 1;
            int l = 0, r = n;
            while (l < r) {
                int mid = l + r >> 1;
                if (sum[mid] >= val) r = mid;
                else l = mid + 1;
            }
            int[] cur = rs[r - 1];
            int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0], y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
            return new int[]{x, y};
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

}