import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 *
 * https://leetcode-cn.com/problems/super-ugly-number/description/
 *
 * algorithms
 * Medium (64.66%)
 * Likes:    223
 * Dislikes: 0
 * Total Accepted:    28.4K
 * Total Submissions: 42.7K
 * Testcase Example:  '12\n[2,7,13,19]'
 *
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32 
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12
 * 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 10^6
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据 保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        // minHeap <val, i, u> 当前丑数，当前丑数由哪个质数派生(index)，当前丑数由哪个丑数派生(index)
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] u = new int[n];
        u[0] = 1;
        for (int i = 0; i < m; i++) {
            q.add(new int[] { primes[i], i, 0 });
        }

        for (int i = 1; i < n;) {
            int[] data = q.poll();
            // <a,b,c>当前丑数 来自b序列，由c产生，则b序列补上c+1产生的下一个丑数
            int val = data[0], udx = data[1], idx = data[2];
            if (val != u[i - 1]) {
                // 是一个非重复的有效丑数
                u[i] = val;
                i++;
            }
            q.add(new int[] { u[idx + 1] * primes[udx], udx, idx + 1 });
        }
        return u[n - 1];

    }
}
// @lc code=end
