package leetcode.editor.cn;

import java.util.Arrays;

//[899] 有序队列
/* "cba",1 */
public class OrderlyQueue {
    public static void main(String[] args) {
        Solution solution = new OrderlyQueue().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String orderlyQueue(String s, int k) {
            if (k == 1) {
                String smallest = s;
                StringBuilder sb = new StringBuilder(s);
                int n = s.length();
                for (int i = 1; i < n; i++) {
                    char c = sb.charAt(0);
                    sb.deleteCharAt(0);
                    sb.append(c);
                    if (sb.toString().compareTo(smallest) < 0) {
                        smallest = sb.toString();
                    }
                }
                return smallest;
            } else {
                char[] arr = s.toCharArray();
                Arrays.sort(arr);
                return new String(arr);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}