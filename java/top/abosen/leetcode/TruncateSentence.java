package top.abosen.leetcode;

//[1816] 截断句子
/* "Hello,how,are,you,Contestant",4 */
public class TruncateSentence {
    public static void main(String[] args) {
        Solution solution = new TruncateSentence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String truncateSentence(String s, int k) {
            int spaceCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    spaceCount++;
                }
                if (spaceCount == k) {
                    return s.substring(0, i);
                }
            }
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}