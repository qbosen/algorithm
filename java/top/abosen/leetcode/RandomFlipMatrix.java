package top.abosen.leetcode;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import top.abosen.leetcode.struct.*;

//[519] 随机翻转矩阵
/* ["Solution","flip","flip","flip","reset","flip"],[[3,1],[],[],[],[],[]] */
public class RandomFlipMatrix {
    public static void main(String[] args) {
        Solution solution = new RandomFlipMatrix().new Solution(100, 100);
        for (int i = 0; i < 5; i++) {
            Set<String> res = new HashSet<>();
            for (int m = 0; m < 10000; m++) {
                int[] flip = solution.flip();
                String identity = flip[0] + "," + flip[1];
                if (res.contains(identity)) {
                    throw new RuntimeException(identity);
                }
                res.add(identity);
            }
            solution.reset();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int m, n, total;
        Random rand = new Random();

        public Solution(int m, int n) {
            this.m = m;
            this.n = n;
            this.total = m * n;
        }

        public int[] flip() {
            int x = rand.nextInt(total);
            total--;
            int idx = map.getOrDefault(x, x);
            map.put(x, map.getOrDefault(total, total));
            return new int[]{idx / n, idx % n};
        }

        public void reset() {
            total = m * n;
            map.clear();
        }
    }


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
//leetcode submit region end(Prohibit modification and deletion)

}