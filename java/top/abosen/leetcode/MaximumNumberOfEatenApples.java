package top.abosen.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

//[1705] 吃苹果的最大数目
/* [1,2,3,5,2],[3,2,1,4,2] */
public class MaximumNumberOfEatenApples {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfEatenApples().new Solution();
        System.out.println(solution.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}) + "==7");
        System.out.println(solution.eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}) + "==5");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            // int[]: [第i天腐败, 苹果数量]
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            int today = 0;
            int n = apples.length;
            int eaten = 0;
            while (today < n || !queue.isEmpty()) {       // 一直吃，直到苹果树不再生产 或 没有存货
                // 1. 扔掉过期的
                while (!queue.isEmpty() && queue.peek()[0] <= today) {
                    queue.poll();
                }
                // 2. 今天产生的新苹果
                if (today < n && apples[today] != 0) {
                    int[] ints = new int[]{today + days[today], apples[today]};
                    queue.offer(ints);
                }
                // 3. 吃一个
                if (!queue.isEmpty()) {
                    if (queue.peek()[1] == 1) {
                        queue.poll();
                    } else {
                        queue.peek()[1]--;
                    }
                    eaten++;
                }
                today++;
            }
            return eaten;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}