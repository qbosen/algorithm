package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[838] 推多米诺
/* "RR.L" */
public class PushDominoes {
    public static void main(String[] args) {
        Solution solution = new PushDominoes().new Solution();
        System.out.println(solution.pushDominoes(".L.R...LR..L.."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String pushDominoes(String dominoes) {
            char[] chars = dominoes.toCharArray();
            int n = chars.length;
            // [idx, time, dire]
            Deque<int[]> deque = new ArrayDeque<>();
            int[] forcedTime = new int[n];

            for (int i = 0; i < n; i++) {
                if (chars[i] == '.') {
                    continue;
                }
                deque.add(new int[]{i, 1, chars[i] == 'L' ? -1 : 1});
                forcedTime[i] = 1;
            }

            while (!deque.isEmpty()) {
                // 已经处于某个状态的
                int[] poll = deque.pollFirst();
                int idx = poll[0], time = poll[1], dire = poll[2];
                int next = idx + dire;
                if (chars[idx] == '.' || (next < 0 || next >= n)) {
                    // 1. 平衡不倒 2. 达到边界
                    continue;
                }
                if (forcedTime[next] == 0) {
                    // 第一次受力
                    forcedTime[next] = time + 1;
                    deque.addLast(new int[]{next, time + 1, dire});
                    chars[next] = dire == -1 ? 'L' : 'R';
                } else if (forcedTime[next] == time + 1) {
                    // 同一时间收到多个力，只能是来自不同方向的平衡力
                    chars[next] = '.';
                } else {
                    // 已经倒下
                }
            }
            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}