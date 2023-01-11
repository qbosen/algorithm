package leetcode.editor.cn;

//[2283] 判断一个数的数字计数是否等于数位的值
/* "1210" */
public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    public static void main(String[] args) {
        Solution solution = new CheckIfNumberHasEqualDigitCountAndDigitValue().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean digitCount(String num) {
            int n = num.length();
            int[] counter = new int[10];
            int[] value = new int[n];
            for (int i = 0; i < n; i++) {
                value[i] = num.charAt(i) - '0';
                counter[value[i]]++;
            }

            for (int i = 0; i < n; i++) {
                if (counter[i] != value[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}