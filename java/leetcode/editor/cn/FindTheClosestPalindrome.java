package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[564] 寻找最近的回文数
/* "123" */
public class FindTheClosestPalindrome {
    public static void main(String[] args) {
        Solution solution = new FindTheClosestPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String nearestPalindromic(String n) {
            long self = Long.parseLong(n);
            int len = n.length();
            List<Long> candidates = new ArrayList<>();
            // 少一位的最大值
            candidates.add((long) Math.pow(10, len - 1) - 1);
            // 多一位的最小值
            candidates.add((long) Math.pow(10, len) + 1);
            // 一半的回文数 +-1
            String half = n.substring(0, (len + 1) / 2);
            long halfN = Long.parseLong(half);
            for (long i : new long[]{halfN, halfN + 1, halfN - 1}) {
                String prefix = String.valueOf(i);
                StringBuilder sb = new StringBuilder(prefix);
                if ((len & 1) == 0) {
                    sb.append(prefix.charAt(prefix.length() - 1));
                }
                for (int j = prefix.length() - 2; j >= 0; j--) {
                    sb.append(prefix.charAt(j));
                }
                candidates.add(Long.parseLong(sb.toString()));
            }

            long res = -1;
            for (long candidate : candidates) {
                if (candidate != self) {
                    if (res == -1 || Math.abs(candidate - self) < Math.abs(res - self) ||
                            Math.abs(candidate - self) == Math.abs(res - self) && candidate < res) {
                        res = candidate;
                    }
                }
            }
            return String.valueOf(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}