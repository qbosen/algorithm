package leetcode.editor.cn;
// 统计重复个数
// 466
// "acb" 4 "ab" 2

import java.util.HashMap;

public class CountTheRepetitions {
    public static void run(Solution solution, int expect, String s1, int n1, String s2, int n2) {
        int result = solution.getMaxRepetitions(s1, n1, s2, n2);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new CountTheRepetitions().new Solution();
        run(solution, 2, "acb", 4, "ab", 2);
        run(solution, 12, "abaacdbac", 100, "adcbd", 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            // 循环结必定出现 s1.l * s2.l + 1
            int cnt1 = 0;
            int cnt2 = 0;
            int j = 0;
            HashMap<Integer, int[]> loops = new HashMap<>(s2.length());
            while (true) {
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        j++;
                        if (j == s2.length()) {
                            cnt2++;
                            j = 0;
                        }
                    }
                }
                cnt1++;
                if (loops.get(j) != null) {
                    break;
                }
                loops.put(j, new int[]{cnt1, cnt2});
            }

            // 循环结长度是s1的倍数
            int[] ints = loops.get(j);
            int s1cntBeforeLoop = ints[0];      // 循环前s1的个数
            int s1cntDuringLoop = cnt1 - s1cntBeforeLoop;   // 一个循环s1的个数
            int s2cntDuringLoop = cnt2 - ints[1];           // 一个循环s2的个数

            int loopCnt = (n1 - s1cntBeforeLoop) / s1cntDuringLoop;   // 循环次数
            int result = loopCnt * s2cntDuringLoop / n2;    // 从循环中获取的结果

            int leftS1cnt = s1cntBeforeLoop + (n1 - s1cntBeforeLoop) % s1cntDuringLoop; // 剩余的s1个数

            // 暴力
            j = 0;
            cnt2 = (loopCnt * s2cntDuringLoop) % n2;  // 循环部分构成n2 剩下的s2个数
            for (int m = 0; m < leftS1cnt; m++) {
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        j++;
                        if (j == s2.length()) {
                            cnt2++;
                            j = 0;
                        }
                    }
                }
            }
            return result + cnt2 / n2;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}