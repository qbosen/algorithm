package top.abosen.leetcode;

import java.util.PriorityQueue;

//[786] 第 K 个最小的素数分数
/* [1,2,3,5],3 */
public class KThSmallestPrimeFraction {
    public static void main(String[] args) {
        Solution solution = new KThSmallestPrimeFraction().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] * b[1] - a[1] * b[0]);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                // 分子，分母，第几组，分母是该组第几个
                queue.add(new int[]{arr[i], arr[n - 1], i, n-1});
            }
            for (int i = 0; i < k-1; i++) {
                int[] poll = queue.poll();
                poll[3]--;
                if(poll[3] < poll[2]){
                    // 该组的所有选择都已弹出
                    poll[0] = poll[1] = Integer.MAX_VALUE;
                }else{
                    poll[0] = arr[poll[2]]; // 每组的分子其实都不会变
                    poll[1] = arr[poll[3]];
                }
                queue.add(poll);
            }
            int[] peek = queue.peek();
            return new int[]{peek[0], peek[1]};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}