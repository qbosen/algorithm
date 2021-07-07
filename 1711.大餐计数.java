import java.util.*;

/*
 * @lc app=leetcode.cn id=1711 lang=java
 *
 * [1711] 大餐计数
 *
 * https://leetcode-cn.com/problems/count-good-meals/description/
 *
 * algorithms
 * Medium (25.56%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    8.8K
 * Total Submissions: 29K
 * Testcase Example:  '[1,3,5,7,9]'
 *
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * 
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i^​​​​​​​​​​​​​​
 * 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
 * 
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countPairs(int[] deliciousness) {
        int max = 0;
        int mod = 1000_000_007;
        Map<Integer, Integer> counter = new HashMap<>();

        for (int d : deliciousness) {
            counter.compute(d, (k, v) -> v == null ? 1 : v + 1);
            max = Math.max(max, d);
        }
        long res = 0;
        // 标记被计算过的pair
        Set<String> set = new HashSet<>();
        // 找出和为 2^i 的组合
        for (int i = 1; i <= 2 * max; i <<= 1) {
            for (Integer a : counter.keySet()) {
                int b = i - a;
                if (!counter.containsKey(b)) {
                    continue;
                }
                String key = a > b ? b + "," + a : a + "," + b;
                if (set.contains(key)) {
                    continue;
                }
                if (a == b) {
                    long cnt = counter.get(a);
                    // 先判断奇偶性 防止溢出
                    boolean odd = (cnt & 0x1) == 1;
                    res = (res + (odd ? (cnt - 1) / 2 * cnt : cnt / 2 * (cnt - 1))) % mod;
                } else {
                    res = (res + (long) counter.get(a) * counter.get(b)) % mod;
                }
                set.add(key);
            }
        }
        return (int) res;
    }
}
// @lc code=end

