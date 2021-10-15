package top.abosen.leetcode;

//[38] 外观数列
/* 1 */
public class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new CountAndSay().new Solution();
        for (int i = 1; i < 10; i++) {

            System.out.println(i + " = "+ solution.countAndSay(i));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String countAndSay(int n) {
            if (n == 1) return "1";
            StringBuilder last = new StringBuilder().append('1');

            for (int i = 2; i <= n; i++) {
                StringBuilder temp = new StringBuilder();
                char prev = last.charAt(0);
                int count = 1;
                for (int j = 1; j < last.length(); j++) {
                    char cur = last.charAt(j);
                    if (cur != prev) {
                        temp.append(count).append(prev);
                        count = 1;
                        prev = cur;
                    } else {
                        count++;
                    }
                }
                temp.append(count).append(prev);
                last = temp;
            }

            return last.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}