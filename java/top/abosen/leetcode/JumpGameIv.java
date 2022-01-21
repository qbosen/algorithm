package top.abosen.leetcode;

import java.util.*;

//[1345] 跳跃游戏 IV
/* [100,-23,-23,404,100,23,23,23,3,404] */
public class JumpGameIv {
    public static void main(String[] args) {
        Solution solution = new JumpGameIv().new Solution();
        int[] ints = new int[100001];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i % 2 == 0 ? 1 : 2;
        }

        System.out.println(solution.minJumps(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minJumps(int[] arr) {
            int step = 0, n = arr.length;
            Map<Integer, List<Integer>> valueIndex = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                // 跳过 相邻且相等的元素
                if ((i != n - 1 && arr[i] == arr[i + 1]) && (i != 0 && arr[i] == arr[i - 1])) continue;
                valueIndex.compute(arr[i], (k, v) -> v == null ? new ArrayList<>() : v).add(i);
            }
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            deque.add(0);
            // 访问过的座标
            Set<Integer> visited = new HashSet<>();
            visited.add(0);

            while (true) {
                int roundSize = deque.size();
                for (int i = 0; i < roundSize; i++) {
                    int curIdx = deque.removeFirst();
                    if (curIdx == n - 1) {
                        return step;
                    }
                    // 1
                    int nextIdx = curIdx + 1;
                    if (nextIdx < n && !visited.contains(nextIdx)) {
                        deque.addLast(nextIdx);
                        visited.add(nextIdx);
                    }
                    // 2
                    nextIdx = curIdx - 1;
                    if (nextIdx >= 0 && !visited.contains(nextIdx)) {
                        deque.addLast(nextIdx);
                        visited.add(nextIdx);
                    }
                    // 3
                    for (int neighborIdx : valueIndex.getOrDefault(arr[curIdx], Collections.emptyList())) {
                        if (curIdx == neighborIdx || visited.contains(neighborIdx)) {
                            continue;
                        }
                        deque.addLast(neighborIdx);
                        visited.add(neighborIdx);
                    }
                    // important 相同值节点只访问一次
                    valueIndex.remove(arr[curIdx]);
                }
                step++;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}