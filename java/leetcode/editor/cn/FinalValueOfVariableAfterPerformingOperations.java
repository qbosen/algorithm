package leetcode.editor.cn;

//[2011] 执行操作后的变量值
/* ["--X","X++","X++"] */
public class FinalValueOfVariableAfterPerformingOperations {
    public static void main(String[] args) {
        Solution solution = new FinalValueOfVariableAfterPerformingOperations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int sum = 0;
            for (String it : operations) {
                int i = it.charAt(1) == '+' ? 1 : -1;
                sum += i;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}